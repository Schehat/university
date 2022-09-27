import { Component } from '@angular/core';
import {RestCallService} from '../rest-call.service';
import { Converter } from './converter';
import {Weather} from './weather';

@Component({
  selector: 'app-celsius-client',
  templateUrl: './celsius-client.component.html',
  styleUrls: ['./celsius-client.component.css']
})
export class CelsiusClientComponent {
  public wetter: Weather[];
  public ort: string;
  public error: string;

  public celsius: number;
  public fahrenheit: number;

  constructor(private rest: RestCallService) {
    // initialisiere Attribute
    this.wetter = [];
    this.ort = "";
    this.celsius = 0;
    this.fahrenheit = 32;
    this.error = "";
  }
  
    getWetter(): void {
      this.rest.getREST(this.ort)
        .subscribe(
          (erg: Weather[]) => { 
            this.wetter = erg; 
          },
           err => { 
             this.error = 'Fehler aufgetaucht';}
        );
    }
  
   calculateFahrenheit(): void {
     this.rest.putREST(this.celsius)
       .subscribe(
         (erg: Converter) => { this.fahrenheit = erg.fahrenheit;},
         error => { this.error = 'Fehler aufgetaucht'; }
       );
   }

}

