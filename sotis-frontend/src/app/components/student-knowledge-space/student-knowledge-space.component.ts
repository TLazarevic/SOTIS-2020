import { NONE_TYPE } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-knowledge-space',
  templateUrl: './student-knowledge-space.component.html',
  styleUrls: ['./student-knowledge-space.component.css']
})
export class StudentKnowledgeSpaceComponent implements OnInit {

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels = ['a', 'a c', 'b c', 'a b c', '{}'];
  public barChartLegend = true;
  public barChartData = [
    {data: [0.1, 0.2, 0.6, 0.05, 0.05 ], label: 'knowledge space probability'},
  ];
  public barChartColors:Array<any> = [{
    backgroundColor: 
    ['#f4c2c2',
    '#1BBC9B',
    '#ffb347',
    '#98fb98',
    '#65C6BB',
    '#5cb85c',
    '#f0ad4e']
 }];
 public options={
  responsive: true,
  legend :{
    'display' : false
  },
  hover: {
      mode: "label" as const
  },
  scales: {
      xAxes: [{
              display: true,
              scaleLabel: {
                  display: true,
                  labelString: 'Knowledge Spaces'
              }
          }],
      yAxes: [{
              display: true,
              ticks: {
                  beginAtZero: true,
                  steps: 5,
                  stepValue: 0.2,
                  max: 1
              }
          }]
  }}

  
  constructor() {}
   
  ngOnInit(): void {
  }

}
