import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarEmpleados } from './guardar-empleados';

describe('GuardarEmpleados', () => {
  let component: GuardarEmpleados;
  let fixture: ComponentFixture<GuardarEmpleados>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarEmpleados]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarEmpleados);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
