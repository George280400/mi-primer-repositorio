import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarCarros } from './guardar-carros';

describe('GuardarCarros', () => {
  let component: GuardarCarros;
  let fixture: ComponentFixture<GuardarCarros>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarCarros]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarCarros);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
