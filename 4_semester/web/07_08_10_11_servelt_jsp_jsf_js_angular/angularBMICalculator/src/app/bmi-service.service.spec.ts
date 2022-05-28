import { TestBed } from '@angular/core/testing';

import { BmiServiceService } from './bmi-service.service';

describe('BmiServiceService', () => {
  let service: BmiServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BmiServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
