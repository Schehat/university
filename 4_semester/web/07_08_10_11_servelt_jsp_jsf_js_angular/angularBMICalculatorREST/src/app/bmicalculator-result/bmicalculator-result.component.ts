import { Component, OnInit } from '@angular/core';
import { BMI } from '../bmi';
import { BMICalculatorService } from '../bmi-calculator.service';
import { ExchangeService } from '../exchange.service';

@Component({
  selector: 'app-bmicalculator-result',
  templateUrl: './bmicalculator-result.component.html',
  styleUrls: ['./bmicalculator-result.component.css']
})
export class BMICalculatorResultComponent implements OnInit {
  public bmi: BMI;
  public maxBMI: number;  // nicht umgesetzt
  public error: string;

  constructor(private exchange: ExchangeService, private bmiService: BMICalculatorService) { 
    this.bmi = new BMI();
    this.maxBMI = 0;
    this.error = "";
  }

  getBMI(): void {
    this.bmiService.getREST(this.bmi.weight, this.bmi.size)
      .subscribe(  // .subscribe with 2 arguments deprecated
        (erg: BMI) => {
          this.bmi = erg;
          this.maxBMI = this.bmi.bmi;
        },
        error => {
          alert("Fehler wurden gemacht");
        }
      );
  }

  ngOnInit(): void {
    this.exchange.subscriber$.subscribe(
      (data: BMI) => {
        this.bmi.weight = data.weight;
        this.bmi.size = data.size;
        this.getBMI();
        }
    )
  }
}
