import { Component, OnInit } from '@angular/core';
import { Nastavnik } from '../model/Nastavnik';
import { Odgovor } from '../model/odgovor';
import { Pitanje } from '../model/pitanje';
import { PitanjeDTO } from '../model/PitanjeDTO';
import { Predmet } from '../model/predmet';
import { Test } from '../model/test';
import { NewQuestionService } from '../services/new-question.service';
import * as fileSaver from 'file-saver';

@Component({
  selector: 'app-new-test',
  templateUrl: './new-test.component.html',
  styleUrls: ['./new-test.component.css']
})
export class NewTestComponent implements OnInit {

  public hiddenUnosTest: boolean;
  public hiddenUnosPitanja: boolean;
  public hiddenPotvrdaTesta: boolean;

  public predmetTempTest: String = new String();

  public krajnjiTest: Test = new Test()

  tempPitanja: Array<Pitanje> = [];

  predmeti: Array<Predmet> = [];
  pitanjaZaPredmet: Array<Pitanje> = []
  odabraniPredmet: Predmet = new Predmet();

  odabranaPitanja: Array<Pitanje> = []
  constructor(private newQuestionService: NewQuestionService) {
    this.hiddenUnosTest = false;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaTesta = true;

    this.newQuestionService.getSviPredmeti().subscribe(response => {this.predmeti = response; this.odabraniPredmet = this.predmeti[0]});

   }


  
  ngOnInit(): void {
  }

  public confirmTest(){
    this.hiddenUnosTest = true;
    this.hiddenUnosPitanja = false;
    this.newQuestionService.getPitanjaZaPredmet(this.odabraniPredmet.id).subscribe(response => this.pitanjaZaPredmet = response);

    console.log(this.odabraniPredmet)

    this.newQuestionService.downloadQtiZip(100).subscribe(response => {
			let blob:any = new Blob([response], { type: 'zip' });
			const url= window.URL.createObjectURL(blob);
			//window.open(url);
			//window.location.href = response.url;
      fileSaver.saveAs(blob, 'QTI.zip');
      console.log(response)
		});


  }

  public addAnswer(){
    
    var odg = new Odgovor();




  }

  public addQuestion(q: Pitanje){

    console.log(q);
    this.odabranaPitanja.push(q);
    this.pitanjaZaPredmet = this.pitanjaZaPredmet.filter(item => item != q);
    
  }

  public removeQuestion(q: Pitanje){
    console.log(q);
    this.pitanjaZaPredmet.push(q);
    this.odabranaPitanja = this.odabranaPitanja.filter(item => item != q);

  }


  public finishTest(){

    var test = new Test();

    // za predmet staviti odabrani
    // za nastavnika na back-u staviti onog koji je ulogovan
    test.nastavnik = new Nastavnik()
    test.pitanje = this.odabranaPitanja;
    test.predmet = this.odabraniPredmet;

    this.krajnjiTest = test;
    console.log(this.krajnjiTest);

    this.hiddenUnosTest = true;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaTesta = false;

  }

  public sendTestToBackend(){
    console.log(this.krajnjiTest);
    this.newQuestionService.dodajTest(this.krajnjiTest).subscribe();
    alert("Success");
  }
}
