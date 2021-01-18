  
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {PitanjeDTO } from '../model/PitanjeDTO';
import { Test } from '../model/test';


@Injectable()
export class NewQuestionService {
  private readonly pitanjeUrl: string;
  private readonly predmetiUrl: string;
  private readonly testUrl: string;
  

  constructor(private http: HttpClient) {
    this.pitanjeUrl = 'http://localhost:8080/pitanje';
    this.predmetiUrl = 'http://localhost:8080/predmet';
    this.testUrl = 'http://localhost:8080/test';
  }

  public getSviPredmeti(){
    //alert("Bice dobavljanje predmeta");
    return this.http.get<any>(this.predmetiUrl);
  }


  public dodajPitanje(pitanje: PitanjeDTO): Observable<any>{
    console.log(pitanje);
    return this.http.post<PitanjeDTO>(this.pitanjeUrl , pitanje);
  }

  public getPitanjaZaPredmet(id: number){
    return this.http.get<any>(this.pitanjeUrl + "/predmet/" + id);
  }

  public dodajTest(test: Test){
    console.log(test);
    return this.http.post<Test>(this.testUrl , test);
  }

  downloadFile(): Observable<any> {
		return this.http.get('http://localhost:8086/test/generateQTI/100', {responseType: 'blob'});
  }

}