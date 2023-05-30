import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BebederoComponent } from './bebedero.component';

describe('BebederoComponent', () => {
  let component: BebederoComponent;
  let fixture: ComponentFixture<BebederoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BebederoComponent]
    });
    fixture = TestBed.createComponent(BebederoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
