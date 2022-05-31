import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BMICalculatorResultComponent } from './bmicalculator-result.component';

describe('BMICalculatorResultComponent', () => {
  let component: BMICalculatorResultComponent;
  let fixture: ComponentFixture<BMICalculatorResultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BMICalculatorResultComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BMICalculatorResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
