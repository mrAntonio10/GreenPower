import { TestBed } from '@angular/core/testing';

import { ViveroService } from './vivero.service';

describe('ViveroService', () => {
  let service: ViveroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViveroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
