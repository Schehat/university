import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { CelsiusToFahrenheitComponent } from './celsius-to-fahrenheit/celsius-to-fahrenheit.component';

@NgModule({
  declarations: [
    AppComponent,
    CelsiusToFahrenheitComponent
  ],
  imports: [
    FormsModule, BrowserModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
