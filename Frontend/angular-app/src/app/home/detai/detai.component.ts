import { Component, OnInit } from '@angular/core';
import { Items } from 'src/app/common/data';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-detai',
  templateUrl: './detai.component.html',
  styleUrls: ['./detai.component.scss']
})
export class DetaiComponent implements OnInit {
  value1: number = 45;
  value2: number = 65;
  value3: number = 75;

  items: Items[] = []

  constructor(private service: DataService) {
  }

  ngOnInit(): void {
    this.getAllItems();
  }

  getAllItems() {
    this.service.getItems().subscribe(data => {
      return this.items = data;
    });
  }

}
