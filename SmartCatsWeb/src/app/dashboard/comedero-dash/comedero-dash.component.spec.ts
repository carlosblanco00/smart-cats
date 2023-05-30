import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComederoDashComponent } from './comedero-dash.component';

describe('ComederoDashComponent', () => {
  let component: ComederoDashComponent;
  let fixture: ComponentFixture<ComederoDashComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComederoDashComponent]
    });
    fixture = TestBed.createComponent(ComederoDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
