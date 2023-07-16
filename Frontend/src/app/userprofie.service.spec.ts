import { TestBed } from '@angular/core/testing';

import { UserprofieService } from './services/userprofie.service';

describe('UserprofieService', () => {
  let service: UserprofieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserprofieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
