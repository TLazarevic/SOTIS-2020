import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

@Injectable({
  providedIn: 'root'
})
export class KnowledgeSpaceService {

  constructor(private http: HttpClient) { }

  // getKnowledgeSpace(id: number) {
  //   return this.http.get<ProstorZnanja>("http://localhost:8080/znanje/" + id, httpOptions)
  // }
}
