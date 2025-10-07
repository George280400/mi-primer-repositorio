import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarVentas } from './guardar-ventas';

describe('GuardarVentas', () => {
  let component: GuardarVentas;
  let fixture: ComponentFixture<GuardarVentas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarVentas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarVentas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
