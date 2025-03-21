import { HttpClientModule } from "@angular/common/http";
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BMICalculatorComponent } from './bmi-calculator/bmi-calculator.component';
import { BMICalculatorResultComponent } from './bmicalculator-result/bmicalculator-result.component';


@NgModule({
  declarations: [
    AppComponent,
    BMICalculatorComponent,
    BMICalculatorResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
