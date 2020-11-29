import { Component, OnInit } from '@angular/core';
import { Nastavnik } from '../model/Nastavnik';
import { Odgovor } from '../model/odgovor';
import { Pitanje } from '../model/pitanje';
import { Predmet } from '../model/predmet';
import { Test } from '../model/test';

@Component({
  selector: 'app-new-test',
  templateUrl: './new-test.component.html',
  styleUrls: ['./new-test.component.css']
})
export class NewTestComponent implements OnInit {

  public hiddenUnosTest: boolean;
  public hiddenUnosPitanja: boolean;
  public hiddenPotvrdaTesta: boolean;

  public textTempTest: String = new String();
  public predmetTempTest: String = new String();
  public textTempPitanje: String = new String();
  public textTempOdgovor: String = new String();
  public tacnostTempOdgovor: boolean;

  public krajnjiTest: Test = new Test()

  tempOdgovori: Array<Odgovor> = [];
  tempPitanja: Array<Pitanje> = [];
  constructor() {
    this.hiddenUnosTest = false;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaTesta = true;

    this.tacnostTempOdgovor = false;
   }


  
  ngOnInit(): void {
  }

  public confirmTest(){
    this.hiddenUnosTest = true;
    this.hiddenUnosPitanja = false;
    alert("Kreiran test: " + this.textTempTest)
  }

  public addAnswer(){
    
    var odg = new Odgovor();
    odg.tacnost = this.tacnostTempOdgovor;
    odg.tekst = this.textTempOdgovor;

    this.tempOdgovori.push(odg)

    
    this.textTempOdgovor = "";
    this.tacnostTempOdgovor = false;

  }

  public addQuestion(){
    var question = new Pitanje();
    question.tekst = this.textTempPitanje;
    this.textTempPitanje = "";
    question.odgovori = this.tempOdgovori;

    this.tempPitanja.push(question)
    console.log(this.tempPitanja)

    this.tempOdgovori = [];
  }


  public finishTest(){

    var test = new Test();

    // za predmet staviti odabrani
    // za nastavnika na back-u staviti onog koji je ulogovan
    test.nastavnik = new Nastavnik()
    test.pitanje = this.tempPitanja;
    test.predmet = new Predmet();

    this.krajnjiTest = test;
    console.log(this.krajnjiTest);

    this.hiddenUnosTest = true;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaTesta = false;

  }

  public sendTestToBackend(){
    alert("Success");
  }
}
