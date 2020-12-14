import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { TestDTO } from '../model/testDTO';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

@Injectable({
  providedIn: 'root'
})
export class TestPreviewService {

  constructor(private http: HttpClient) { }

  getTestsByUcenik(id: number) {
    return this.http.get<TestDTO[]>("http://localhost:8080/test/ucenik/" + id, httpOptions)
  }

  getAllTests() {
    return this.http.get<TestDTO[]>("http://localhost:8080/test/all")
  }

}
