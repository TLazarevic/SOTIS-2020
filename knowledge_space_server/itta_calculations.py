import psycopg2
import pandas as pd
import numpy as np
import pickle
from http.server import HTTPServer, BaseHTTPRequestHandler
import json

import sys

sys.path.append('learning_spaces/')
from learning_spaces.kst import iita


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
    query = "INSERT INTO cvor(string_id,label, pitanje_id, pz_id) " \
            "VALUES(%s,%s, %s, %s)"
    try:
        cursor = conn.cursor()
        cursor.executemany(query, [(string_id, label, pitanje_id, pz_id)])
        conn.commit()
    finally:
        cursor.close()


def insert_prostor_stanja(conn, predmet_id):
    query = "INSERT INTO prostor_znanja(predmet_id) VALUES(%s) RETURNING id"
    try:
        cursor = conn.cursor()
        cursor.execute(query, predmet_id)
        prostor_znanja_id = cursor.fetchall()[0][0]
        print(prostor_znanja_id)
        return prostor_znanja_id
        conn.commit()
    finally:
        cursor.close()


def calculate_itta(conn, prostor_znanja_id):
    '''
        ***JOS SAMO OVO DA SE ODRADI***

        for ucenik in ucenici:
            dict = {}
            for cvor in cvorovi:
                pitanje = pitanja[cvor]
                if pitanje.tacno == True:
                    list = []
                    list.append(1)
                    dict.update( { cvor_id : list})
                else:
                    list = []
                    list.append(0)
                    dict.update( { cvor_id : list})
                df2 = pd.DataFrame.from_dict(dict)
                data_frame = data_frame.append(df2, ignore_index=True)

        ## AKO ZATREBA NESTO ODAVDE
        data_frame = pd.DataFrame({'100': [1, 0, 0], '200': [0, 1, 0], '300': [0, 1, 1]})

        # dodavanje odgovora sledeceg ucenika
        new_dict = {}

        new_dict.update( {'100': 47})
        new_dict.update({'200': 48})
        lista = []
        lista.append(49)
        new_dict.update({'300': lista})

        print(new_dict)
        df3 = pd.DataFrame.from_dict(new_dict)
        data_frame = data_frame.append(df3, ignore_index=True)
        print(data_frame)
        ##

    '''
    data_frame = pd.DataFrame({'100': [1, 0, 0], '200': [0, 1, 0], '300': [0, 1, 1]})

    # dodavanje odgovora sledeceg ucenika
    # df2 = pd.DataFrame({'a': [1], 'b': [1], 'c': [1]})
    # data_frame = data_frame.append(df2, ignore_index=True)

    response = iita(data_frame, v=1)
    # response_list = list(response)
    pairs = response['implications']

    index = data_frame.columns.values
    a_list = list(index)
    print(a_list[1])
    for pair in pairs:
        print(pair)
        print((a_list[pair[0]], a_list[pair[1]]))
        insert_veza(conn, '10', '10', prostor_znanja_id, a_list[pair[0]], a_list[pair[1]])


def start_algorithm():
    # povezivanje na bazu
    conn = connect_to_database()
    cur = conn.cursor()
    cur.execute('SELECT * FROM predmet')
    predmeti = cur.fetchall()
    cur.close()

    # za razlicite predmete pravim razl prostore znanja
    for x in predmeti:
        print(x[0])
        predmet_id = x[0]
        prostor_znanja_id = insert_prostor_stanja(conn, str(predmet_id))
        # za pitanja iz prostora znanja pravim nove cvorove
        cur = conn.cursor()
        cur.execute('SELECT * FROM pitanje where predmet_id = ' + str(predmet_id))
        pitanja = cur.fetchall()
        for pitanje in pitanja:
            pitanje_id = pitanje[0]
            insert_cvor(conn, "1", "label", str(pitanje_id), str(prostor_znanja_id))

        cur.close()

        calculate_itta(conn, prostor_znanja_id)


if __name__ == '__main__':

    start_algorithm()
    print("End")
