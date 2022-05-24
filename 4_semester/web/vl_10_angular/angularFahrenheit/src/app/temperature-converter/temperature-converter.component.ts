import { Component, OnInit } from '@angular/core';
import {TemperatureService} from '../temperature.service';

@Component({
  selector: 'app-temperature-converter',
  templateUrl: './temperature-converter.component.html',
  styleUrls: ['./temperature-converter.component.css']
})
export class TemperatureConverterComponent {
  
  public celsius: number;

  constructor(private obj: TemperatureService) {
    this.celsius = 0;
  }
  getFahrenheit(): string {
    const fahrenheit = this.obj.
            convertCelsiusToFahrenheit(this.celsius);
    return fahrenheit.toFixed(2);
  }
  addCelsius(): void {
    this.celsius += 10;
  }

}
