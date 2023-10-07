import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PruebaTablaComponent } from './prueba-tabla.component';

describe('PruebaTablaComponent', () => {
  let component: PruebaTablaComponent;
  let fixture: ComponentFixture<PruebaTablaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PruebaTablaComponent]
    });
    fixture = TestBed.createComponent(PruebaTablaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
