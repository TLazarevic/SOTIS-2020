import { Component, OnInit, ViewChild } from '@angular/core';
import { Subject } from 'rxjs';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { NewNodeDialogComponent } from '../new-node-dialog/new-node-dialog.component';
import { MatMenuTrigger } from '@angular/material/menu';
import { LinkDialogComponent } from '../link-dialog/link-dialog.component';

@Component({
  selector: 'app-knowledge-preview',
  templateUrl: './knowledge-preview.component.html',
  styleUrls: ['./knowledge-preview.component.css']
})
export class KnowledgePreviewComponent implements OnInit {
  // @ViewChild(MatMenuTrigger) trigger!: MatMenuTrigger;

  center$: Subject<boolean> = new Subject();
  zoomToFit$: Subject<boolean> = new Subject();
  update$: Subject<boolean> = new Subject();
  label!: string;

  nodes = [
    {
      id: 'A',
      label: 'A'
    }, {
      id: 'B',
      label: 'B'
    }, {
      id: 'C',
      label: 'C'
    }, {
      id: 'D',
      label: 'D'
    }, {
      id: 'E',
      label: 'E'
    }
  ]

  links = [
    {
      id: 'a',
      source: 'A',
      target: 'B',
      label: 'is parent of'
    }, {
      id: 'b',
      source: 'A',
      target: 'C',
      label: 'custom label'
    }, {
      id: 'c',
      source: 'B',
      target: 'D',
      label: 'custom label'
    }, {
      id: 'd',
      source: 'B',
      target: 'E',
      label: 'custom label'
    }
  ]

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  onNodeSelect(node: any) {
    console.log(node)
    const dialogRef = this.dialog.open(NewNodeDialogComponent, {
      width: '250px',
      data: { "source": node.id }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result.source && result.source != "") {
        this.nodes.push({
          id: result.label,
          label: result.label
        })
        this.links.push({
          id: result.label,
          source: node.id,
          target: result.label,
          label: 'custom label'
        })
      }
      else {
        this.nodes.push({
          id: result.label,
          label: result.label
        })
      }
      this.update$.next(true)
    });

  }

  addLink(event: any) {
    const dialogRef = this.dialog.open(LinkDialogComponent, {
      width: '250px',
      data: { "nodes": this.nodes }
    });

    dialogRef.afterClosed().subscribe(result => {

      this.links.push({
        id: result.source + " " + result.target,
        source: result.source,
        target: result.target,
        label: 'custom label'
      })

      this.update$.next(true)
    });
  }

  onRightClick(node: any) {

    // this.trigger.openMenu();

    var id = (node.path[2].id)
    console.log(id)
    this.removeByAttr(this.nodes, "id", id);
    this.removeByAttr(this.links, "source", id);
    this.removeByAttr(this.links, "target", id);
    this.update$.next(true)
    return false;
  }

  removeByAttr = function (arr: any[], attr: string | number, value: any) {
    var i = arr.length;
    while (i--) {
      if (
        arr[i] &&
        arr[i].hasOwnProperty(attr) &&
        arguments.length > 2 && arr[i][attr] === value
      ) {
        arr.splice(i, 1);
      }
    }
    return arr;
  };

  centerGraph() {
    this.center$.next(true)
  }

  fitGraph() {
    this.zoomToFit$.next(true)
  }

}
