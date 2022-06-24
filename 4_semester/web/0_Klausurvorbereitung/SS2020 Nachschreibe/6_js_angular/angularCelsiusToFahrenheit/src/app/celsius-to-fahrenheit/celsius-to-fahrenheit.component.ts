import { Component } from '@angular/core';

@Component({
  selector: 'app-celsius-to-fahrenheit',
  templateUrl: './celsius-to-fahrenheit.component.html',
  styleUrls: ['./celsius-to-fahrenheit.component.css']
})
export class CelsiusToFahrenheitComponent {
  public celsius : number;
  public fahrenheit: number;
  constructor() { 
    this.celsius = 0;
    this.fahrenheit = 0;
  }
    convert() : void {
    this.fahrenheit = this.celsius*1.8 + 32;
  }
}
