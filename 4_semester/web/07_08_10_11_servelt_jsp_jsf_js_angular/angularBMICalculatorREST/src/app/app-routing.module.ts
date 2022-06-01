import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BMICalculatorComponent } from './bmi-calculator/bmi-calculator.component';
import { BMICalculatorResultComponent } from './bmicalculator-result/bmicalculator-result.component';

const routes: Routes = [
  {path: "input", component: BMICalculatorComponent},
  {path: "result", component: BMICalculatorResultComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
