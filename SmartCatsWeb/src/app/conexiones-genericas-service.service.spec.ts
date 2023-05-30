import { TestBed } from '@angular/core/testing';

import { ConexionesGenericasServiceService } from './conexiones-genericas-service.service';

describe('ConexionesGenericasServiceService', () => {
  let service: ConexionesGenericasServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConexionesGenericasServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
