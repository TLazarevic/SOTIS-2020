import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-knowledge-preview',
  templateUrl: './knowledge-preview.component.html',
  styleUrls: ['./knowledge-preview.component.css']
})
export class KnowledgePreviewComponent implements OnInit {

  center$: Subject<boolean> = new Subject();
  zoomToFit$: Subject<boolean> = new Subject();

  constructor() { }

  ngOnInit(): void {
  }

  onNodeSelect(event: Event) {
    console.log('working')
  }

  centerGraph() {
    this.center$.next(true)
  }

  fitGraph() {
    this.zoomToFit$.next(true)
  }

}
