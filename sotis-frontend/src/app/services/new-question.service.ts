  
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {PitanjeDTO } from '../model/PitanjeDTO';


@Injectable()
export class NewQuestionService {
  private readonly dodajPitanjeUrl: string;
  private readonly createModelUrl: string;
  

  constructor(private http: HttpClient) {
    this.dodajPitanjeUrl = 'http://localhost:8080/pitanje';
    this.createModelUrl = 'http://localhost:8079/admin-service/model/';
  }

  public getMoguciPredmeti(){
    alert("Bice dobavljanje predmeta");
    //return this.http.get<any>(this.getUsersUrl + '/True');
  }


  public dodajPitanje(pitanje: PitanjeDTO): Observable<any>{
    console.log(pitanje);
    return this.http.post<PitanjeDTO>(this.dodajPitanjeUrl , pitanje);
  }

}