import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BMI } from '../bmi';
import { BMICalculatorService } from '../bmi-calculator.service';
import { ExchangeService } from '../exchange.service';

@Component({
  selector: 'app-bmi-calculator',
  templateUrl: './bmi-calculator.component.html',
  styleUrls: ['./bmi-calculator.component.css']
})
export class BMICalculatorComponent implements OnInit {
  public weight: number;
  public size: number;
  public bmi: BMI;
  public maxBMI: number;
  public error: string;

  constructor(private bmiService: BMICalculatorService, private router: Router,
      private exchange: ExchangeService) {
    this.size = 180
    this.weight = 70;
    this.bmi = new BMI();
    this.maxBMI = 0;
    this.error = "";
  }

  getBMI(): void {
    this.bmiService.getREST(this.weight, this.size)
      .subscribe(  // .subscribe with 2 arguments deprecated
        (erg: BMI) => {
          this.bmi = erg;
          if (this.bmi.bmi > this.maxBMI)
            this.maxBMI = this.bmi.bmi;
        },
        error => {
          alert("Fehler wurden gemacht");
        }
      );
  }

  goToAusgabeView(): void {
    // da REST-Anfragen asynchron wird das dataToTransfer 
    // nicht mit richtigen bmi und ergebnis initialisiert
    // => 2. Komponente muss selbst REST-Anfrage stellen
    // this.getBMI();
    let dataToTransfer = new BMI();
    // dataToTransfer.bmi = this.bmi.bmi;
    // dataToTransfer.ergebnis = this.bmi.ergebnis;
    dataToTransfer.weight = this.weight;
    dataToTransfer.size = this.size;
    localStorage.setItem("maxBMI", this.maxBMI.toString(2));
    this.exchange.saveData(dataToTransfer);
    this.router.navigate(["/result"]);
  }

  ngOnInit(): void {
  }

}
