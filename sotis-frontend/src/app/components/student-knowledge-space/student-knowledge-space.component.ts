import { ActivatedRoute } from '@angular/router';
import { MarkovPZ } from './../../model/MarkovPZ';
import { KnowledgeService } from 'src/app/services/knowledge.service';
import { NONE_TYPE } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-student-knowledge-space',
  templateUrl: './student-knowledge-space.component.html',
  styleUrls: ['./student-knowledge-space.component.css']
})
export class StudentKnowledgeSpaceComponent implements OnInit {

  public dataRecieved = false

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels: any[] = [];
  public barChartLegend = true;
  public barChartData!: [{ data: number[]; label: string; }]
  public barChartColors: Array<any> = [{
    backgroundColor:
      ['#f4c2c2',
        '#1BBC9B',
        '#ffb347',
        '#98fb98',
        '#65C6BB',
        '#5cb85c',
        '#f0ad4e']
  }];
  public options = {
    maintainAspectRatio:false,
    responsive: true,
    legend: {
      'display': false
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
          steps: 10,
          stepValue: 0.1,
          max: 1
        }
      }]
    }
  }


  constructor(private pzService: KnowledgeService, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      var testId = params['id'];
      var ucenikId = params['ucenikId']
      this.pzService.getMarkovPZ(testId, ucenikId).subscribe(data => {

        var probabs: number[] = []

        for (let m of data) {
          this.barChartLabels.push(m.pz)
          console.log(m)
          probabs.push(m.verovatnoca)
        }

        
        this.barChartData = [
          { data: probabs, label: 'knowledge space probability' },
        ];
        this.dataRecieved=true

      })
    })
    
  }

  ngOnInit(): void {
  }

}
