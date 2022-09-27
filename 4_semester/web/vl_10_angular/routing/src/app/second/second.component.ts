import { Component, OnInit } from '@angular/core';
import { ExchangeService } from '../exchange.service';
import { Temperature } from '../temperature';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {
  public celsius: number;
  public text: string;

  constructor(private exchange: ExchangeService) {
    this.celsius = 0;
    this.text = "cold";
  }

  ngOnInit(): void {
    this.exchange.subscriber$.subscribe(
      (data: Temperature) => {
      this.celsius = data.grad;})
  }
  
  calcFahrenheit(): number {
    if (this.celsius < 15) this.text = "es ist kalt !";
    else this.text = "es ist warm! ";
    return this.celsius * 1.8 + 32;
  }
}
