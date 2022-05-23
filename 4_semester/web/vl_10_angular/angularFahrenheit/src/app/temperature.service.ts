import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TemperatureService {
  convertCelsiusToFahrenheit(celsius: number): number {
    return celsius * 1.8 + 32;
  }
}
