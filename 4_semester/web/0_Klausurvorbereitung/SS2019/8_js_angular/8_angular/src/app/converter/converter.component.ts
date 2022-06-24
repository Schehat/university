import { Component } from '@angular/core';

@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})
/* export class ConverterComponent {
  public menge : number;
  public distanz : number;
  public verbrauch : number;;

  constructor() {
    this.menge = 0;
    this.distanz = 0;
    this.verbrauch = 0;
  }

  public berechneVerbrauch() : void {
    this.verbrauch =  this.menge / this.distanz * 100; 
  }
} */

export class ConverterComponent {
  public celsius : number;
  public fahrenheit: number;
  constructor() { 
    this.celsius = 0;
    this.fahrenheit = 0;
  }
  public convert() : void {
    this.fahrenheit = this.celsius*1.8 + 32;
  }
}