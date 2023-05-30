import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreneroComponent } from './arenero.component';

describe('AreneroComponent', () => {
  let component: AreneroComponent;
  let fixture: ComponentFixture<AreneroComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AreneroComponent]
    });
    fixture = TestBed.createComponent(AreneroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
