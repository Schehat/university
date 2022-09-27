import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { BMI } from './bmi';


@Injectable({
  providedIn: 'root'
})
export class BMICalculatorService {

  constructor(private http: HttpClient) { }

  public getREST(weight: number, size: number) {
    let url = "http://localhost:8080/BMIApplication/api/BMIResource";
    let seachParam = {"gewicht": weight, "groese": size};
    return this.http.get<BMI>(url, {params: seachParam });
  }
}
