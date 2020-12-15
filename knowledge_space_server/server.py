import pandas as pd
import numpy as np
import pickle
from http.server import HTTPServer, BaseHTTPRequestHandler
import json


import sys
sys.path.append('learning_spaces/')
from learning_spaces.kst import iita

'''
    Serverski deo
'''
class helloHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header('content-type', 'text/html')
        self.end_headers()

        # parametri dati u url-u, razdvojeni '/' karakterom
        parametri = self.path[1:].split('/')
        korisnik = parametri[1]
        print('Korisnik za predlog: ' + str(korisnik))



def start_server():
    PORT = 8000
    server = HTTPServer(('', PORT), helloHandler)
    print('Server runing on port: ' + str(PORT))
    server.serve_forever()

if __name__ == '__main__':
    start_server()
    print('Kraj')