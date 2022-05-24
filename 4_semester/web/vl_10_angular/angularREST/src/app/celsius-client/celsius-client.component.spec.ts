import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CelsiusClientComponent } from './celsius-client.component';

describe('CelsiusClientComponent', () => {
  let component: CelsiusClientComponent;
  let fixture: ComponentFixture<CelsiusClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CelsiusClientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CelsiusClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
