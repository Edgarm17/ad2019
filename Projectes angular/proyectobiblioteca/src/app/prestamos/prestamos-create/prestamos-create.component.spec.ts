import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrestamosCreateComponent } from './prestamos-create.component';

describe('PrestamosCreateComponent', () => {
  let component: PrestamosCreateComponent;
  let fixture: ComponentFixture<PrestamosCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrestamosCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrestamosCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
