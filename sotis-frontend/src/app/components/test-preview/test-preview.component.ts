import { Component, OnInit } from '@angular/core';
import { Pitanje } from 'src/app/model/pitanje';
import { Predmet } from 'src/app/model/predmet';
import { TestViewDTO } from 'src/app/model/testViewDTO';
import { PageEvent } from '@angular/material/paginator';
import { Odgovor } from 'src/app/model/odgovor';

import { TakeTestService } from 'src/app/services/take-test.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NextQDTO } from 'src/app/model/NextQDTO';
import { ThrowStmt } from '@angular/compiler';

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

  // MatPaginator Output
  pageEvent: PageEvent = new PageEvent;
  testId!: number;

  pitanje!: Pitanje
  kSpaces!: []
  probabs!: []
  tacnost!: number
  preostalaPitanja!: []

  constructor(private takeTestService: TakeTestService, private route: ActivatedRoute, private router: Router) {

    this.route.params.subscribe(params => {
      this.testId = params['id'];
      console.log(this.testId)
      this.takeTestService.getTest(this.testId).subscribe(data => {
        this.test = data
        console.log(this.test)
        this.pageEvent.pageIndex = 0

        this.studentAnswers = this.test
        for (let p of this.studentAnswers.pitanje) {
          for (let o of p.odgovori) {
            o.tacnost = false;
          }
        }
        this.takeTestService.startTest(this.testId).subscribe(data => {
          this.pitanje = data.pitanje
          this.preostalaPitanja = data.preostalaPitanja
          this.kSpaces = data.kSpaces
          this.probabs = data.probabs
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
    nqd.kSpaces = this.kSpaces
    nqd.probabs = this.probabs
    nqd.tacnost = 1
    nqd.pitanje = this.pitanje
    nqd.preostalapitanja=this.preostalaPitanja

    console.log(nqd)
    this.takeTestService.nextQ(this.testId, nqd).subscribe(data => {
      if(data!=null){
        this.probabs = data.probabs
        this.pitanje = data.pitanje
        this.preostalaPitanja = data.preostalaPitanja
        this.kSpaces = data.kSpaces
        alert(this.pitanje)
      }else{
        this.finished = true
      }
    })
  }


}
