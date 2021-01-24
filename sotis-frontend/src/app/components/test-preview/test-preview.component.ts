import { ProbabilityQuestionDTO } from './../../model/ProbabilityQuestionDTO';
import { Component, OnInit } from '@angular/core';
import { TestViewDTO } from 'src/app/model/testViewDTO';
import { PageEvent } from '@angular/material/paginator';
import { Odgovor } from 'src/app/model/odgovor';

import { TakeTestService } from 'src/app/services/take-test.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NextQDTO } from 'src/app/model/NextQDTO';

const ZAKUCANO = 100


@Component({
  selector: 'app-test-preview',
  templateUrl: './test-preview.component.html',
  styleUrls: ['./test-preview.component.css']
})
export class TestPreviewComponent implements OnInit {

  test!: TestViewDTO;
  testSize: number = 0;
  studentAnswers: TestViewDTO = new TestViewDTO;
  finished = false

  pageEvent: PageEvent = new PageEvent;
  testId!: number;
  ucenikId!: number;

  pqd!: ProbabilityQuestionDTO
  odgovori: Odgovor[] = []

  constructor(private takeTestService: TakeTestService, private route: ActivatedRoute) {

    this.route.params.subscribe(params => {
      this.testId = params['id'];
      this.ucenikId = ZAKUCANO
      this.takeTestService.getTest(this.testId).subscribe(data => {

        this.test = data
        console.log("DATA: ")
        console.log(data)
        this.pageEvent.pageIndex = 0

        this.studentAnswers = this.test
        for (let p of this.studentAnswers.pitanje) {
          for (let o of p.odgovori) {
            o.tacnost = false;
          }
        }
        this.takeTestService.startTest(this.testId, this.ucenikId).subscribe(data => {
          this.pqd = data
          console.log(data)
          for (let pitanje of this.studentAnswers.pitanje) {
            if (pitanje.id == this.pqd.pitanje.id) {
              this.odgovori = pitanje.odgovori
            }
          }
        })
      })
    }
    )

  }

  ngOnInit(): void {

  }

  submit() {
    // console.log(this.studentAnswers)
    // this.takeTestService.sendAnswers(this.studentAnswers, ZAKUCANO).subscribe()
    // alert('submitted')
    // this.router.navigate(['/Tests']);

    var nqd = new NextQDTO;
    nqd.kSpaces = this.pqd.kSpaces
    nqd.probabs = this.pqd.probabs
    nqd.tacnost = 1
    console.log(this.test)

    for (let pitanje of this.test.pitanje) {
      if (pitanje.id == this.pqd.pitanje.id) {
        for (let odgovor of this.odgovori) {
          for (let odgovor2 of pitanje.odgovori) {
            if (odgovor.id == odgovor2.id) {
              console.log(odgovor)
              console.log(odgovor2)
              if (odgovor.tacnost != odgovor2.tacnost) {
                nqd.tacnost = 0
              }
            }
          }
        }
      }
    }
    nqd.pitanje = this.pqd.pitanje
    nqd.preostalapitanja = this.pqd.preostalaPitanja
    nqd.l = this.pqd.l
    nqd.ucenikId = this.ucenikId
    nqd.testId = this.testId

    console.log(nqd)
    this.takeTestService.nextQ(this.testId, nqd).subscribe(data => {
      if (data.preostalaPitanja != undefined) {
        this.pqd = data
        this.testId = data.testId
        this.ucenikId = data.ucenikId
        for (let pitanje of this.studentAnswers.pitanje) {
          if (pitanje.id == this.pqd.pitanje.id) {
            this.odgovori = pitanje.odgovori
          }
        }
      } else {
        this.finished = true
      }
    })
  }


}
