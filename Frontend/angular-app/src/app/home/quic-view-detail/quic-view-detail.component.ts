import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-quic-view-detail',
  templateUrl: './quic-view-detail.component.html',
  styleUrls: ['./quic-view-detail.component.scss']
})
export class QuicViewDetailComponent implements OnInit {
  @Input() percentage!: number;
  @Input() color!: string;

  constructor() { }

  ngOnInit(): void {
  }

}
