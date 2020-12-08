import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

export class DialogData {
  label: string = "";
  source: string = "";
}
@Component({
  selector: 'app-new-node-dialog',
  templateUrl: './new-node-dialog.component.html',
  styleUrls: ['./new-node-dialog.component.css']

})
export class NewNodeDialogComponent implements OnInit {

  constructor(  public dialogRef: MatDialogRef<NewNodeDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) { }

  ngOnInit(): void {
  }

}
