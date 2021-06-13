import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-quick-view',
  templateUrl: './quick-view.component.html',
  styleUrls: ['./quick-view.component.scss']
})
export class QuickViewComponent implements OnInit {
  @Input() icon = '';
  @Input() caption = '';
  constructor() { }

  ngOnInit(): void {
  }

}
