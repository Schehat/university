import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Temperature } from './temperature';

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {
  observer = new BehaviorSubject<Temperature>( new Temperature(0) );

  public subscriber$ = this.observer.asObservable();

  saveData(data : Temperature) {
    this.observer.next(data);
  }
}

