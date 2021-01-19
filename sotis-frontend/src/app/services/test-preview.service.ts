import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { TestDTO } from '../model/testDTO';
import {Observable, throwError} from 'rxjs';

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

  downloadQtiZip(testId: number): Observable<any> {
		return this.http.get('http://localhost:8080/test/generateQTI/' + testId, {responseType: 'blob'});
  }
}
