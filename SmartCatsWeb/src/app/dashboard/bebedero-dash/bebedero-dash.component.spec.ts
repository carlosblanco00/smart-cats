import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BebederoDashComponent } from './bebedero-dash.component';

describe('BebederoDashComponent', () => {
  let component: BebederoDashComponent;
  let fixture: ComponentFixture<BebederoDashComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BebederoDashComponent]
    });
    fixture = TestBed.createComponent(BebederoDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
