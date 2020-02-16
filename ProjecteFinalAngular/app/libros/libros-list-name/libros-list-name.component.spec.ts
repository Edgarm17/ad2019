import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrosListNameComponent } from './libros-list-name.component';

describe('LibrosListNameComponent', () => {
  let component: LibrosListNameComponent;
  let fixture: ComponentFixture<LibrosListNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibrosListNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrosListNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
