import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComederoComponent } from './comedero.component';

describe('ComederoComponent', () => {
  let component: ComederoComponent;
  let fixture: ComponentFixture<ComederoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComederoComponent]
    });
    fixture = TestBed.createComponent(ComederoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
