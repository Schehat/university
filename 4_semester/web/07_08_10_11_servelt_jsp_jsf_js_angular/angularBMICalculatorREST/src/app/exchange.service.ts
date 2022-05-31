import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { BMI } from './bmi';

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {
  observer = new BehaviorSubject<BMI>(new BMI());

  public subscriber$ = this.observer.asObservable();

  saveData(data: BMI) {
    this.observer.next(data);
  }

  constructor() { }
}
