import { Component, OnInit } from '@angular/core';
import { TestDTO } from 'src/app/model/testDTO';
import { TestPreviewService } from 'src/app/services/test-preview.service';
import { Router } from '@angular/router';
import * as fileSaver from 'file-saver';

const zakucano = 100

@Component({
  selector: 'app-tests-preview',
  templateUrl: './tests-preview.component.html',
  styleUrls: ['./tests-preview.component.css']
})

export class TestsPreviewComponent implements OnInit {

  tests: TestDTO[] = [];

  constructor(private testService: TestPreviewService, private router: Router) {

    this.testService.getTestsByUcenik(zakucano).subscribe(
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

  downloadQTI(id: number){
    this.testService.downloadQtiZip(id).subscribe(response => {
			let blob:any = new Blob([response], { type: 'zip' });
			const url= window.URL.createObjectURL(blob);
			//window.open(url);
			//window.location.href = response.url;
      fileSaver.saveAs(blob, 'test-' + id + '-QTI.zip');
      console.log(response)
		});
  }


}
