import { TestBed, inject } from '@angular/core/testing';

import { NetworthService } from './networth.service';

describe('NetworthService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NetworthService]
    });
  });

  it('should be created', inject([NetworthService], (service: NetworthService) => {
    expect(service).toBeTruthy();
  }));
});
