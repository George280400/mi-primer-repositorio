import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarResponsables } from './editar-responsables';

describe('EditarResponsables', () => {
  let component: EditarResponsables;
  let fixture: ComponentFixture<EditarResponsables>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarResponsables]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarResponsables);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
