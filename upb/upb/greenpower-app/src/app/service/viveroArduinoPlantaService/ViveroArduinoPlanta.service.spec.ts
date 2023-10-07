import { TestBed } from '@angular/core/testing';

import { ViveroArduinoPlanta } from './viveroArduinoPlanta.service';

describe('ViveroArduinoPlantaService', () => {
  let service: ViveroArduinoPlanta;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViveroArduinoPlanta);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
