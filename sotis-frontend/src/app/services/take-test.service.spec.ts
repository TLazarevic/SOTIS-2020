import { TestBed } from '@angular/core/testing';

import { TakeTestService } from './take-test.service';

describe('TakeTestService', () => {
  let service: TakeTestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TakeTestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
