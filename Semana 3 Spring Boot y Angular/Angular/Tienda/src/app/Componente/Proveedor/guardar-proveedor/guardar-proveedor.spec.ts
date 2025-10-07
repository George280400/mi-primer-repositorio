import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarProveedor } from './guardar-proveedor';

describe('GuardarProveedor', () => {
  let component: GuardarProveedor;
  let fixture: ComponentFixture<GuardarProveedor>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarProveedor]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarProveedor);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
