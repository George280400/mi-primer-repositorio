import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarMascotas } from './guardar-mascotas';

describe('GuardarMascotas', () => {
  let component: GuardarMascotas;
  let fixture: ComponentFixture<GuardarMascotas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarMascotas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarMascotas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
