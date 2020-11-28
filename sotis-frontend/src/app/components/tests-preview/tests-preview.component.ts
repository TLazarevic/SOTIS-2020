import { Component, OnInit } from '@angular/core';
import { TestDTO } from 'src/app/model/testDTO';
import { TestPreviewService } from 'src/app/services/test-preview.service';


const zakucano = 1

@Component({
  selector: 'app-tests-preview',
  templateUrl: './tests-preview.component.html',
  styleUrls: ['./tests-preview.component.css']
})

export class TestsPreviewComponent implements OnInit {

  tests: TestDTO[] = [];

  constructor(private testService: TestPreviewService) {
    // this.tests = [];
    // this.tests.push(new TestDTO("SOTIS"));
    // this.tests.push(new TestDTO("Neuronske mreze"));
    this.testService.getTestsByNastavnik(zakucano).subscribe(
      data => {
        this.tests = data;
      }
    )
  }

  ngOnInit(): void {
  }

}
