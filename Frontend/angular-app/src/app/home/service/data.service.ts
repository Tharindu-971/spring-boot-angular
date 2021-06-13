import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Items } from 'src/app/common/data';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  items: Items[] | undefined;
  url: string = "http://localhost:8085/item";
  constructor(private http: HttpClient) { }

  getItems(): Observable<Items[]> {
    return this.http.get<Items[]>(this.url);
  }
}
