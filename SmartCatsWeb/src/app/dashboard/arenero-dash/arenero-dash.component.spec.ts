import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreneroDashComponent } from './arenero-dash.component';

describe('AreneroDashComponent', () => {
  let component: AreneroDashComponent;
  let fixture: ComponentFixture<AreneroDashComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AreneroDashComponent]
    });
    fixture = TestBed.createComponent(AreneroDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
