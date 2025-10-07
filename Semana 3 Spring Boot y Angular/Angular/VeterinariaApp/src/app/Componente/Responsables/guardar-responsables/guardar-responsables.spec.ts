import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarResponsables } from './guardar-responsables';

describe('GuardarResponsables', () => {
  let component: GuardarResponsables;
  let fixture: ComponentFixture<GuardarResponsables>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarResponsables]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarResponsables);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
