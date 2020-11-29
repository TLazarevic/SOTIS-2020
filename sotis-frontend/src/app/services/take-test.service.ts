import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TestViewDTO } from '../model/testViewDTO';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

@Injectable({
  providedIn: 'root'
})
export class TakeTestService {

  constructor(private http: HttpClient) { }

  sendAnswers(test: TestViewDTO, id: number) {

    return this.http.post("http://localhost:8080/test/uradjen/" + id, test, httpOptions)
  }

  getTest(id:number){
    return this.http.get<TestViewDTO>("http://localhost:8080/test/"+id)
  }
}
