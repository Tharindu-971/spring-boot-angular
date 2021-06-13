import { Component, Input, OnInit } from '@angular/core';
import { Items } from '../data';

@Component({
  selector: 'app-table-view',
  templateUrl: './table-view.component.html',
  styleUrls: ['./table-view.component.scss']
})
export class TableViewComponent implements OnInit {

  @Input()
  data!: Items[];

  constructor() { }

  ngOnInit(): void {
  }

}
