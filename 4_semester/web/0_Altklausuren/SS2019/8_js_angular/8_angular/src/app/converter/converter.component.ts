import { Component } from '@angular/core';

@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})
export class ConverterComponent {
  public menge : number = 0;
  public distanz : number = 0;

  constructor() {}

  berechneVerbrauch() : number {
    return this.menge / this.distanz * 100; 
  }
}
