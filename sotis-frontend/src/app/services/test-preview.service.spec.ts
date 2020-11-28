import { TestBed } from '@angular/core/testing';

import { TestPreviewService } from './test-preview.service';

describe('TestPreviewService', () => {
  let service: TestPreviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestPreviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
