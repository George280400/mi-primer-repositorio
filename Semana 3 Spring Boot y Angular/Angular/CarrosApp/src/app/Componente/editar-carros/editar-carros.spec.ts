import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarCarros } from './editar-carros';

describe('EditarCarros', () => {
  let component: EditarCarros;
  let fixture: ComponentFixture<EditarCarros>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarCarros]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarCarros);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
