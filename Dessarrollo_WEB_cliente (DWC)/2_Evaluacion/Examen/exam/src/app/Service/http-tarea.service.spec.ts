import { TestBed } from '@angular/core/testing';

import { HttpTareaService } from './http-tarea.service';

describe('HttpTareaService', () => {
  let service: HttpTareaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpTareaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
