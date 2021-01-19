import { MarkovPZ } from './../model/MarkovPZ';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Predmet } from '../model/predmet';
import { ProstorZnanja } from '../model/ProstorZnanja';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
const options = {
  responseType: 'text' as const,
};

@Injectable({
  providedIn: 'root'
})
export class KnowledgeService {

  constructor(private http: HttpClient) { }

  getGraph(id: number) {
    return this.http.get<ProstorZnanja>("http://localhost:8080/znanje/" + id, httpOptions)
  }

  getGraphs(predmetId: number) {
    return this.http.get<ProstorZnanja[]>("http://localhost:8080/znanje/predmet/" + predmetId, httpOptions)
  }

  newGraph(pz: ProstorZnanja) {
    return this.http.post<Boolean>("http://localhost:8080/znanje", pz, httpOptions)
  }

  allPredmeti() {
    return this.http.get<Predmet[]>("http://localhost:8080/predmet", httpOptions)
  }

  generateIttaGraph(){
    return this.http.get<any>("http://localhost:8000");

  }

  getStringGraph(id:number){
    return this.http.get("http://localhost:8080/znanje/toString/"+id, options)
  }

  getMarkovPZ(testId:number, ucenikId:number){
    return this.http.get<MarkovPZ[]>("http://localhost:8080/znanje/markov/"+ucenikId+"/"+testId, httpOptions)
  }
}
