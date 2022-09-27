import { Component } from '@angular/core';
import {Router} from '@angular/router';
import { ExchangeService } from '../exchange.service';
import {Temperature} from '../temperature';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {
    public celsius: number;
    
    constructor(private router: Router, private exchange: ExchangeService) { 
      this.celsius = 0;
    }

    gotToAusgabeView(): void {
      let dataToTransfer = new Temperature(this.celsius);
      this.exchange.saveData(dataToTransfer);
      this.router.navigate(['/second']);
    }
}

