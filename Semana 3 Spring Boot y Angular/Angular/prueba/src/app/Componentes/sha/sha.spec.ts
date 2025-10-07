import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Sha } from './sha';

describe('Sha', () => {
  let component: Sha;
  let fixture: ComponentFixture<Sha>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Sha]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Sha);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
