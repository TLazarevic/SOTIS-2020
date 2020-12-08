  
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {PitanjeDTO } from '../model/PitanjeDTO';


@Injectable()
export class NewQuestionService {
  private readonly dodajPitanjeUrl: string;
  private readonly predmetiUrl: string;
  

  constructor(private http: HttpClient) {
    this.dodajPitanjeUrl = 'http://localhost:8080/pitanje';
    this.predmetiUrl = 'http://localhost:8080/predmet';
  }

  public getSviPredmeti(){
    //alert("Bice dobavljanje predmeta");
    return this.http.get<any>(this.predmetiUrl);
  }


  public dodajPitanje(pitanje: PitanjeDTO): Observable<any>{
    console.log(pitanje);
    return this.http.post<PitanjeDTO>(this.dodajPitanjeUrl , pitanje);
  }

}