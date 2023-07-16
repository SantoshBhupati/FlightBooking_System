import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelticketComponent } from './cancelticket.component';

describe('CancelticketComponent', () => {
  let component: CancelticketComponent;
  let fixture: ComponentFixture<CancelticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CancelticketComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CancelticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
