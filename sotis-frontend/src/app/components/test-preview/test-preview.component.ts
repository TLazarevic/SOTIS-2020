import { Component, OnInit } from '@angular/core';
import { Pitanje } from 'src/app/model/pitanje';
import { Predmet } from 'src/app/model/predmet';
import { TestViewDTO } from 'src/app/model/test';
import { PageEvent } from '@angular/material/paginator';
import { Odgovor } from 'src/app/model/odgovor';
import { TakeTestService } from 'src/app/services/take-test.service';
import { ActivatedRoute } from '@angular/router';

const ZAKUCANO = 1

@Component({
  selector: 'app-test-preview',
  templateUrl: './test-preview.component.html',
  styleUrls: ['./test-preview.component.css']
})
export class TestPreviewComponent implements OnInit {

  test!: TestViewDTO;
  testSize: number = 0;
  studentAnswers: TestViewDTO = new TestViewDTO;

  // MatPaginator Output
  pageEvent: PageEvent = new PageEvent;
  testId!: number;


  constructor(private takeTestService: TakeTestService, private route: ActivatedRoute) {

    // this.test = new Test();
    // var pitanje1 = new Pitanje();
    // pitanje1.tekst = "blabla"
    // var odgovor11 = new Odgovor();
    // odgovor11.tekst = "tekstOdgovora1"
    // odgovor11.tacnost = true;
    // pitanje1.odgovori.push(odgovor11);
    // var pitanje2 = new Pitanje();
    // pitanje2.tekst = "blabla2"
    // var odgovor21 = new Odgovor();
    // odgovor21.tekst = "tekstOdgovora2"
    // odgovor21.tacnost = false;
    // pitanje2.odgovori.push(odgovor21);
    // this.test.pitanje.push(pitanje1);
    // this.test.pitanje.push(pitanje2);

    this.route.params.subscribe(params => {
      this.testId = params['id'];
      console.log(this.testId)
      this.takeTestService.getTest(this.testId).subscribe(data => {
        this.test = data
       console.log(this.test)
        this.pageEvent.pageIndex = 0

        this.studentAnswers =this.test
        for (let p of this.studentAnswers.pitanje) {
          for (let o of p.odgovori) {
            o.tacnost = false;
          }
        }
      })
    }
    )

  }

  ngOnInit(): void {

  }

  submit() {
    console.log(this.studentAnswers)
    this.takeTestService.sendAnswers(this.studentAnswers, ZAKUCANO).subscribe()
  }


}
