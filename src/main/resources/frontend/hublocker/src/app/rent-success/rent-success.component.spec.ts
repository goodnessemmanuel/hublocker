import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentSuccessComponent } from './rent-success.component';

describe('RentSuccessComponent', () => {
  let component: RentSuccessComponent;
  let fixture: ComponentFixture<RentSuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RentSuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RentSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
