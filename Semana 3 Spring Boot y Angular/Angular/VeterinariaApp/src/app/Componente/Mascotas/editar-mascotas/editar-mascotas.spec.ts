import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarMascotas } from './editar-mascotas';

describe('EditarMascotas', () => {
  let component: EditarMascotas;
  let fixture: ComponentFixture<EditarMascotas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarMascotas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarMascotas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
