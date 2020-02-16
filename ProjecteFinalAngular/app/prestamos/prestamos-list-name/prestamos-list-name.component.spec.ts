import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrestamosListNameComponent } from './prestamos-list-name.component';

describe('PrestamosListNameComponent', () => {
  let component: PrestamosListNameComponent;
  let fixture: ComponentFixture<PrestamosListNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrestamosListNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrestamosListNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
