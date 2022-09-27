import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BmiServiceService {

  constructor() { }

  getBMI(size: number, weight: number): number {
    if (size <= 0 || weight <= 0 || size > 220 || weight > 150) 
      throw alert("Sinnvolle Eingaben tätigen!")
    return Math.round((weight / Math.pow((size / 100.0), 2) * 100)) / 100;
  }

  getResult(bmi: number): string {
    if (bmi < 18.5) {
      return "Sie sind untergewichtig (< 18,5) !";
    } else if (bmi > 25) {
      return "Sie sind übergewichtig (25 bis 29,9) !";
    } else {
      return "Sie sind normalgewichtig (18,5 bis 24,9) !";
    }
  }
}