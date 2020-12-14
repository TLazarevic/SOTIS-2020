import { Component, OnInit } from '@angular/core';
import { Nastavnik } from '../model/Nastavnik';
import { Odgovor } from '../model/odgovor';
import { Pitanje } from '../model/pitanje';
import { PitanjeDTO } from '../model/PitanjeDTO';
import { Predmet } from '../model/predmet';
import { Test } from '../model/test';
import { NewQuestionService } from '../services/new-question.service';
import { KnowledgeService } from 'src/app/services/knowledge.service';
import { VezaDTO } from 'src/app/model/VezaDTO';
import { ProstorZnanja } from 'src/app/model/ProstorZnanja';
import { Veza } from 'src/app/model/Veza';
import { Cvor } from 'src/app/model/Cvor';
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

  nodes: Cvor[] = []


  links: VezaDTO[] = []
  ///
  public hiddenUnosTest: boolean;
  public hiddenUnosPitanja: boolean;
  public hiddenPotvrdaPitanja: boolean;

  public predmetTempTest: String = new String();
  public textTempPitanje: String = new String();
  public textTempOdgovor: String = new String();
  public tacnostTempOdgovor: boolean;


  odabraniCvor: Cvor = new Cvor(-1,"","");

  tempOdgovori: Array<Odgovor> = [];
  tempPitanja: Array<Pitanje> = [];

  pitanjaZaPredmet: Array<Pitanje> = []

  predmeti: Array<Predmet> = [];
  odabraniPredmet: Predmet = new Predmet();

  constructor(private newQuestionService: NewQuestionService,private knowledgeService: KnowledgeService) {
    this.hiddenUnosTest = false;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaPitanja = true;

    this.tacnostTempOdgovor = false;

    var ZAKUCANO = 1
    knowledgeService.getGraph(ZAKUCANO).subscribe(data => {
      this.nodes = data.cvorovi
      for (let v of data.veze) {
        this.links.push(new VezaDTO(v))
      }
    })
   }

  ngOnInit(): void {

    // dobavljanje predmeta za odabir
    this.newQuestionService.getSviPredmeti().subscribe(response => {this.predmeti = response; this.odabraniPredmet = this.predmeti[0]});
    
  }

  // proveravam da li vec postoji pitanje sa tim cvorom, ako ne postoji postavljam taj cvor za odabrani
  onNodeSelect(node: any) {

    var slobodno: Boolean;
    slobodno = true;
    this.pitanjaZaPredmet.forEach(function (value) {

      if(value.cvor.cvorId == node.cvorId){
        slobodno = false;
        alert("Za odabrani cvor je vec uneto pitanje");
        return;
      }
    }); 

    if (slobodno){
      console.log(node.label)
      this.odabraniCvor = node;
    }

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
    this.newQuestionService.getPitanjaZaPredmet(this.odabraniPredmet.id).subscribe(response => this.pitanjaZaPredmet = response);

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

    console.log(this.pitanjaZaPredmet)
  }



  public sendQuestionToBackend(){

    let pitanje: PitanjeDTO = new PitanjeDTO();
    pitanje.tekst = this.textTempPitanje
    pitanje.odgovori = this.tempOdgovori
    pitanje.predmetId = this.odabraniPredmet.id;
    pitanje.cvor = this.odabraniCvor;

   
    this.newQuestionService.dodajPitanje(pitanje).subscribe( next => alert("Success"));
    
    this.hiddenUnosTest = false;
    this.hiddenUnosPitanja = true;
    this.hiddenPotvrdaPitanja = true;

    this.tacnostTempOdgovor = false;
    this.tempOdgovori = [];
    this.odabraniCvor = new Cvor(-1,"", "");
    this.textTempPitanje = "";
  }

}
