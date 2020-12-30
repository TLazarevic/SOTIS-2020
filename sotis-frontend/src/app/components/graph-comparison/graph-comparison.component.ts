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
  update2$: Subject<boolean> = new Subject();
  label!: string;
  curve = shape.curveLinear

  showGraphs = false;
  predmeti: Predmet[] = [];

  nodes!: Cvor[]
  links: VezaDTO[] = []
  id!: number

  nodes2!: Cvor[]
  links2: VezaDTO[] = []
  id2!: number

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
      if (data[1].generisan == true) {
        this.nodes = data[0].cvorovi
        this.nodes2 = data[1].cvorovi
        for (let v of data[0].veze) {
          this.links.push(new VezaDTO(v))
        }
        for (let v of data[1].veze) {
          this.links2.push(new VezaDTO(v))
        }
        this.id = data[0].id
        this.id2 = data[1].id
      } else {
        this.nodes = data[1].cvorovi
        this.nodes2 = data[0].cvorovi
        for (let v of data[1].veze) {
          this.links.push(new VezaDTO(v))
        }
        for (let v of data[0].veze) {
          this.links2.push(new VezaDTO(v))
        }
        this.id = data[1].id
        this.id2 = data[0].id
      }


      this.showGraphs = true
    }
    )
  }

  public generateKnowledgeSpace() {
    this.knowledgeService.generateIttaGraph().subscribe(next => alert("Knowledge space is generated"));
  }

  public getLevenstein() {
    var string1 = ""
    var string2 = ""
    this.knowledgeService.getStringGraph(this.id).subscribe(data => {
      string1 = data
      this.knowledgeService.getStringGraph(this.id2).subscribe(data2 => {
        string2 = data2
        console.log(string1)
        console.log(string2)
        alert(Number(this.similarity(string1, string2)))
      }
      )
    })

  }

  getBasic() {
      for (let veza of this.links){
        if(this.links2.find(x => x.source == veza.source &&  x.target == veza.target)==undefined){
          var newVeza=veza
          newVeza.color = 'red'
          this.links2.push(newVeza)
          console.log(newVeza)
          this.update2$.next(true)
        }
      }

      for (let veza of this.links2){
        if(this.links.find(x => x.source == veza.source &&  x.target == veza.target)==undefined){
          var newVeza=veza
          newVeza.color = 'red'
          this.links.push(newVeza)
          console.log(newVeza)
          this.update$.next(true)
        }
      }
      
  }

  levenshtein(a: String, b: String): number {
    const an = a ? a.length : 0;
    const bn = b ? b.length : 0;
    if (an === 0) {
      return bn;
    }
    if (bn === 0) {
      return an;
    }
    const matrix = new Array<number[]>(bn + 1);
    for (let i = 0; i <= bn; ++i) {
      let row = matrix[i] = new Array<number>(an + 1);
      row[0] = i;
    }
    const firstRow = matrix[0];
    for (let j = 1; j <= an; ++j) {
      firstRow[j] = j;
    }
    for (let i = 1; i <= bn; ++i) {
      for (let j = 1; j <= an; ++j) {
        if (b.charAt(i - 1) === a.charAt(j - 1)) {
          matrix[i][j] = matrix[i - 1][j - 1];
        }
        else {
          matrix[i][j] = Math.min(
            matrix[i - 1][j - 1], // substitution
            matrix[i][j - 1], // insertion
            matrix[i - 1][j] // deletion
          ) + 1;
        }
      }
    }
    return matrix[bn][an];
  };

  //The common way of calculating the similarity between two strings in a 0%-100% fashion, as used in many libraries,
  // is to measure how much (in %) you'd have to change the longer string to turn it into the shorter:
  similarity(s1: String, s2: String) {
    var longer = s1, shorter = s2;
    if (s1.length < s2.length) { // longer should always have greater length
      longer = s2; shorter = s1;
    }
    var longerLength = longer.length;
    if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
    return (longerLength - this.levenshtein(longer, shorter)) / longerLength;
  }

}
