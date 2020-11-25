import { Component, OnInit } from '@angular/core';
import { TestDTO } from 'src/app/model/testDTO';

@Component({
  selector: 'app-tests-preview',
  templateUrl: './tests-preview.component.html',
  styleUrls: ['./tests-preview.component.css']
})
export class TestsPreviewComponent implements OnInit {

  tests:TestDTO[];

  constructor() { 
    this.tests = [];
    this.tests.push(new TestDTO("SOTIS"));
    this.tests.push(new TestDTO("Neuronske mreze"));
  }

  ngOnInit(): void {
  }

}
