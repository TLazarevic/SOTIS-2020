import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ucenik } from '../model/Ucenik';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }
  register(user: Ucenik) {
    return this.http.post("http://localhost:8080/user/ucenik/" , user, httpOptions)
  }

  login(user: Ucenik){
    return this.http.post<String>("http://localhost:8080/user/login/" , user, httpOptions)
  }
}
