import { Component, OnInit } from '@angular/core';
import { Nastavnik } from '../model/Nastavnik';
import { Odgovor } from '../model/odgovor';
import { Pitanje } from '../model/pitanje';
import { PitanjeDTO } from '../model/PitanjeDTO';
import { Predmet } from '../model/predmet';
import { Test } from '../model/Test';
import { NewQuestionService } from '../services/new-question.service';

// imports for graph
import { Subject } from 'rxjs';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatMenuTrigger } from '@angular/material/menu';

@Component({
  selector: 'app-new-pitanje',
  templateUrl: './new-pitanje.component.html',
  styleUrls: ['./new-pitanje.component.css']
})
export class NewPitanjeComponent implements OnInit {

  ///
  center$: Subject<boolean> = new Subject();
  zoomToFit$: Subject<boolean> = new Subject();
  update$: Subject<boolean> = new Subject();
  label!: string;

  nodes = [
    {
      id: 'A',
      label: 'A'
    }, {
      id: 'B',
      label: 'B'
    }, {
      id: 'C',
      label: 'C'
    }, {
      id: 'D',
      label: 'D'
    }, {
      id: 'E',
      label: 'E'
    }
  ]

  links = [
    {
      id: 'a',
      source: 'A',
      target: 'B',
      label: 'is parent of'
    }, {
      id: 'b',
      source: 'A',
      target: 'C',
      label: 'custom label'
    }, {
      id: 'c',
      source: 'B',
      target: 'D',
      label: 'custom label'
    }, {
      id: 'd',
      source: 'B',
      target: 'E',
      label: 'custom label'
    }
  ]
  ///
  public hiddenUnosTest: boolean;
  public hiddenUnosPitanja: boolean;
  public hiddenPotvrdaPitanja: boolean;

  public predmetTempTest: String = new String();
  public textTempPitanje: String = new String();
  public textTempOdgovor: String = new String();
  public tacnostTempOdgovor: boolean;


  odabraniCvor: String = ""

  tempOdgovori: Array<Odgovor> = [];
  tempPitanja: Array<Pitanje> = [];

  predmeti: Array<Predmet> = [];
  odabraniPredmet: Predmet = new Predmet();

  constructor(private newQuestionService: NewQuestionService) {
    this.hiddenUnosTest = false;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaPitanja = true;

    this.tacnostTempOdgovor = false;
   }

  ngOnInit(): void {

    // dobavljanje predmeta za odabir
    this.newQuestionService.getSviPredmeti().subscribe(response => {this.predmeti = response; this.odabraniPredmet = this.predmeti[0]});
    
  }

  onNodeSelect(node: any) {
    console.log(node.label)
    this.odabraniCvor = node.label;
  }
  onRightClick(node: any) {

    // this.trigger.openMenu();
  }  
  centerGraph() {
    this.center$.next(true)
  }

  fitGraph() {
    this.zoomToFit$.next(true)
  }

  public confirmTest(){
    this.hiddenUnosTest = true;
    this.hiddenUnosPitanja = false;
    console.log(this.odabraniPredmet);
    alert(this.odabraniPredmet.naziv);
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

    question.odgovori = this.tempOdgovori;

    this.tempPitanja.push(question)

    this.hiddenUnosTest = true;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaPitanja = false;
  }



  public sendQuestionToBackend(){

    let pitanje: PitanjeDTO = new PitanjeDTO();
    pitanje.tekst = this.textTempPitanje
    pitanje.odgovori = this.tempOdgovori
    pitanje.predmetId = this.odabraniPredmet.id;
    this.newQuestionService.dodajPitanje(pitanje).subscribe();
    alert("Success");
    this.hiddenUnosTest = false;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaPitanja = true;

    this.tacnostTempOdgovor = false;
    this.tempOdgovori = [];
  }

}
