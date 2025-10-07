import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarCategoria } from './guardar-categoria';

describe('GuardarCategoria', () => {
  let component: GuardarCategoria;
  let fixture: ComponentFixture<GuardarCategoria>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarCategoria]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarCategoria);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
