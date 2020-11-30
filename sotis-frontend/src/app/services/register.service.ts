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
    const user1 = JSON.stringify(user);
    return this.http.post("http://localhost:8080/user/ucenik/" , user, httpOptions)
  }
}
