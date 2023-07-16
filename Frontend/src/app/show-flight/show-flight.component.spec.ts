import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowFlightComponent } from './show-flight.component';

describe('ShowFlightComponent', () => {
  let component: ShowFlightComponent;
  let fixture: ComponentFixture<ShowFlightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowFlightComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
