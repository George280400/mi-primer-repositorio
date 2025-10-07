import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarVeterinarias } from './editar-veterinarias';

describe('EditarVeterinarias', () => {
  let component: EditarVeterinarias;
  let fixture: ComponentFixture<EditarVeterinarias>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarVeterinarias]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarVeterinarias);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
