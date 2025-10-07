import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarVentas } from './editar-ventas';

describe('EditarVentas', () => {
  let component: EditarVentas;
  let fixture: ComponentFixture<EditarVentas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarVentas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarVentas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
