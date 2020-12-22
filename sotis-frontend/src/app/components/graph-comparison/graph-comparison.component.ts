import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { KnowledgeService } from 'src/app/services/knowledge.service';
import * as shape from 'd3-shape';
import { Predmet } from 'src/app/model/predmet';
import { Cvor } from 'src/app/model/Cvor';
import { Veza } from 'src/app/model/Veza';
import { VezaDTO } from 'src/app/model/VezaDTO';

@Component({
  selector: 'app-graph-comparison',
  templateUrl: './graph-comparison.component.html',
  styleUrls: ['./graph-comparison.component.css']
})
export class GraphComparisonComponent implements OnInit {

  center$: Subject<boolean> = new Subject();
  zoomToFit$: Subject<boolean> = new Subject();
  update$: Subject<boolean> = new Subject();
  label!: string;
  curve = shape.curveBundle

  showGraphs = false;
  predmeti: Predmet[] = [];
  nodes!: Cvor[]
  links: VezaDTO[] = []
  nodes2!: Cvor[]
  links2: VezaDTO[] = []
  selected = ""

  constructor(private knowledgeService: KnowledgeService) {
    knowledgeService.allPredmeti().subscribe(
      data => {
        this.predmeti = data
        console.log(data)
      }
    )
  }

  ngOnInit(): void {
  }

  getGraph(event: any) {
    console.log(this.selected)
    this.nodes = []; this.links = []; this.update$.next(true)
    this.knowledgeService.getGraphs(Number(this.selected)).subscribe(data => {
      console.log(data)
      this.nodes = data[0].cvorovi
      this.nodes2 = data[1].cvorovi
      for (let v of data[0].veze) {
        this.links.push(new VezaDTO(v))
      }
      for (let v of data[1].veze) {
        this.links2.push(new VezaDTO(v))
      }

      this.showGraphs = true
    }
    )
  }

  public generateKnowledgeSpace(){
    this.knowledgeService.generateIttaGraph().subscribe( next => alert("Knowledge space is generated"));
  }

}
