import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarVeterinarias } from './listar-veterinarias';

describe('ListarVeterinarias', () => {
  let component: ListarVeterinarias;
  let fixture: ComponentFixture<ListarVeterinarias>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarVeterinarias]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarVeterinarias);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
