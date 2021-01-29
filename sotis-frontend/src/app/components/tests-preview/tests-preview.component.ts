import { Component, OnInit } from '@angular/core';
import { TestDTO } from 'src/app/model/testDTO';
import { TestPreviewService } from 'src/app/services/test-preview.service';
import { Router } from '@angular/router';
import * as fileSaver from 'file-saver';


@Component({
  selector: 'app-tests-preview',
  templateUrl: './tests-preview.component.html',
  styleUrls: ['./tests-preview.component.css']
})

export class TestsPreviewComponent implements OnInit {

  tests: TestDTO[] = [];
  loggedIn!: number

  constructor(private testService: TestPreviewService, private router: Router) {

    this.loggedIn = Number(localStorage.getItem("loggedIn"))
    this.testService.getTestsByUcenik(this.loggedIn).subscribe(
      data => {
        this.tests = data;
        console.log(this.tests[0])

      }
    )
  }

  ngOnInit(): void {

  }

  submit(id: number) {
    this.router.navigate(['/Test', { id: id }]);
  }

  getPZ(id: number) {
    this.router.navigate(['/student-ks', { id: id, ucenikId: this.loggedIn }]);
  }

  downloadQTI(id: number) {
    this.testService.downloadQtiZip(id).subscribe(response => {
      let blob: any = new Blob([response], { type: 'zip' });
      const url = window.URL.createObjectURL(blob);
      //window.open(url);
      //window.location.href = response.url;
      fileSaver.saveAs(blob, 'test-' + id + '-QTI.zip');
      console.log(response)
    });
  }


}
