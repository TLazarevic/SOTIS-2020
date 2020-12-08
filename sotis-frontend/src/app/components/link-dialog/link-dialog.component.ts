import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

export class DialogDataLinks {
  nodes: any[] = [];
}

export class Link {
  source: string = ""
  target: string = ""
}

@Component({
  selector: 'app-link-dialog',
  templateUrl: './link-dialog.component.html',
  styleUrls: ['./link-dialog.component.css']
})
export class LinkDialogComponent implements OnInit {

  selected: Link = new Link()

  constructor(public dialogRef: MatDialogRef<LinkDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogDataLinks) { }

  ngOnInit(): void {
  }

}
