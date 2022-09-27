import { Component, OnInit } from '@angular/core';
import { BmiServiceService } from '../bmi-service.service';

@Component({
  selector: 'app-bmi-calculator',
  templateUrl: './bmi-calculator.component.html',
  styleUrls: ['./bmi-calculator.component.css']
})
export class BmiCalculatorComponent implements OnInit {
  public size: number;
  public weight: number;
  private bmi: number;
  private result: string;
  private maxBMI: number;

  constructor(private bmiService: BmiServiceService) {
    this.size = 180
    this.weight = 70;
    this.bmi = 0;
    this.result = "";
    this.maxBMI = 0;
  }

  getBMI(): number {
    return this.bmi;
  }

  getResult(): string {
    return this.result;
  }

  getMaxBMI(): number {
    return this.maxBMI;
  }

  evaluate(): void {
    console.log(this.size + " " + this.weight);
    this.bmi = this.bmiService.getBMI(this.size, this.weight);
    this.result = this.bmiService.getResult(this.bmi);
    if (this.bmi > this.maxBMI)
      this.maxBMI = this.bmi;
  }

  ngOnInit(): void {
  }

}
