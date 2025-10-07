import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarVeterinarias } from './guardar-veterinarias';

describe('GuardarVeterinarias', () => {
  let component: GuardarVeterinarias;
  let fixture: ComponentFixture<GuardarVeterinarias>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarVeterinarias]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarVeterinarias);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
