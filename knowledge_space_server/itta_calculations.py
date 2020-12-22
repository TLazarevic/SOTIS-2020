import psycopg2
import pandas as pd
import requests
import sys

sys.path.append('learning_spaces/')
from learning_spaces.kst import iita

def get_matrix_from_java():
    # hardkodovano je na 100, tu ce samo da ide ono sto se posalje sa fronta
    URL = "http://localhost:8080/test/matrica/100"
    r = requests.get(url=URL)
    data = r.json()

    data_frame = pd.DataFrame()

    for matrica in data:
        matrica = data[matrica]
        for ucenik in matrica:
            ucenik = matrica[ucenik]
            dict = {}
            for pitanje in ucenik:
                list = []
                list.append(int(ucenik[pitanje]))
                dict.update( {pitanje : list} )
                print(str(pitanje) + " | " + str(ucenik[pitanje]))
            df2 = pd.DataFrame.from_dict(dict)
            data_frame = data_frame.append(df2, ignore_index=True)

    return data_frame

def get_dict_pitanje_label(predmet_id = 1):
    URL = "http://localhost:8080/znanje/predmet/" + str(predmet_id)

    r = requests.get(url=URL)
    data = r.json()

    dict_pitanje_label = {}
    for prostor in data:
        if prostor["generisan"] == False:
            for cvor in prostor["cvorovi"]:
                if cvor["pitanje"] == None:
                    continue
                else:
                    dict_pitanje_label.update({int(cvor["pitanje"]) : str(cvor["label"])})
            print("returndje")
            return dict_pitanje_label
    print(data)
    return dict_pitanje_label

def connect_to_database():
    conn = psycopg2.connect(
        host="localhost",
        database="sotis_db",
        user="postgres",
        password="admin")
    return conn

# conn - konekcija na bazu
def insert_veza(conn, string_id, label, pz_id, source_cvor_id, target_cvor_id):
    query = "INSERT INTO veza(string_id,label, pz_id, source_cvor_id, target_cvor_id) " \
            "VALUES(%s,%s, %s, %s, %s)"
    try:
        cursor = conn.cursor()
        cursor.executemany(query, [(string_id, label, pz_id, source_cvor_id, target_cvor_id)])
        conn.commit()
    finally:
        cursor.close()


def insert_cvor(conn, string_id, label, pitanje_id, pz_id):
    query = "INSERT INTO cvor(string_id,label, pitanje_id, pz_id) VALUES(%s,%s, %s, %s) RETURNING cvor_id"
    try:
        cursor = conn.cursor()
        cursor.execute(query, (string_id, label, pitanje_id, pz_id))
        cvor_id = cursor.fetchall()[0][0]
        conn.commit()
        return cvor_id
    finally:
        cursor.close()


def insert_prostor_stanja(conn, predmet_id):
    query = "INSERT INTO prostor_znanja(generisan, predmet_id) VALUES(%s, %s) RETURNING id"
    try:
        cursor = conn.cursor()
        cursor.execute(query, ("True", predmet_id))
        prostor_znanja_id = cursor.fetchall()[0][0]
        print(prostor_znanja_id)
        conn.commit()

        return prostor_znanja_id
    finally:
        cursor.close()


def calculate_itta(conn, prostor_znanja_id, dict_pitanje_cvor, dict_pitanje_label):
    #data_frame = pd.DataFrame({'100': [1, 0, 0], '200': [0, 1, 0], '300': [0, 1, 1]})
    data_frame = get_matrix_from_java()


    response = iita(data_frame, v=1)
    pairs = response['implications']

    index = data_frame.columns.values
    a_list = list(index)
    print(a_list[1])
    for pair in pairs:
        print((a_list[pair[0]], a_list[pair[1]]))

        cvor1_id = dict_pitanje_cvor[int(a_list[pair[0]])]
        cvor2_id = dict_pitanje_cvor[int(a_list[pair[1]])]


        insert_veza(conn, '10', '10', prostor_znanja_id, cvor1_id, cvor2_id)


def start_algorithm():
    # povezivanje na bazu
    conn = connect_to_database()
    cur = conn.cursor()
    cur.execute('SELECT * FROM predmet')
    predmeti = cur.fetchall()
    cur.close()
    dict_pitanje_cvor = {}

    # za razlicite predmete pravim razl prostore znanja
    for predmet in predmeti:
        print(predmet[0])
        predmet_id = predmet[0]
        prostor_znanja_id = insert_prostor_stanja(conn, str(predmet_id))
        # za pitanja iz prostora znanja pravim nove cvorove
        cur = conn.cursor()
        cur.execute('SELECT * FROM pitanje where predmet_id = ' + str(predmet_id))
        pitanja = cur.fetchall()
        dict_pitanje_label = get_dict_pitanje_label(predmet_id)
        for pitanje in pitanja:
            pitanje_id = pitanje[0]

            cvor_label = str(pitanje[2])
            if pitanje_id in dict_pitanje_label:
                cvor_label = dict_pitanje_label[pitanje_id]


            cvor_id = insert_cvor(conn, cvor_label, cvor_label, str(pitanje_id), str(prostor_znanja_id))
            dict_pitanje_cvor.update( {int(pitanje_id) : int(cvor_id)} )
        cur.close()

        calculate_itta(conn, prostor_znanja_id, dict_pitanje_cvor, get_dict_pitanje_label(predmet_id))


if __name__ == '__main__':
    start_algorithm()
    print("End")
