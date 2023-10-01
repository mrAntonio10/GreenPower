import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivacionActuadoresComponent } from './activacion-actuadores.component';

describe('ActivacionActuadoresComponent', () => {
  let component: ActivacionActuadoresComponent;
  let fixture: ComponentFixture<ActivacionActuadoresComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ActivacionActuadoresComponent]
    });
    fixture = TestBed.createComponent(ActivacionActuadoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
