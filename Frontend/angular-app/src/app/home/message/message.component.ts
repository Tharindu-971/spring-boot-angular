import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

  @Input() success!: boolean;
  @Input() warning!: boolean;
  @Input() info!: boolean;
  @Input() danger!: boolean;
  constructor() { }

  ngOnInit(): void {
  }

}
