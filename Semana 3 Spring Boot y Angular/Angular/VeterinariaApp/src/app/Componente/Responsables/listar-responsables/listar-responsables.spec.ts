import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarResponsables } from './listar-responsables';

describe('ListarResponsables', () => {
  let component: ListarResponsables;
  let fixture: ComponentFixture<ListarResponsables>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarResponsables]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarResponsables);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
