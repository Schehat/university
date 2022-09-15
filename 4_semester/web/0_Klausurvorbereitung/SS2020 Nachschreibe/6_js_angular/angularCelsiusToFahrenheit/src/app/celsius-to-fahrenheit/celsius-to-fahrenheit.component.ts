import { Component } from '@angular/core';

@Component({
  selector: 'app-celsius-to-fahrenheit',
  templateUrl: './celsius-to-fahrenheit.component.html',
  styleUrls: ['./celsius-to-fahrenheit.component.css']
})
export class CelsiusToFahrenheitComponent {
  public celsius : number = 0;
  constructor() { }
    convert() : number {
      return this.celsius*1.8 + 32;
  }
}
