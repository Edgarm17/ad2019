import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrosListComponent } from './libros-list.component';

describe('LibrosListComponent', () => {
  let component: LibrosListComponent;
  let fixture: ComponentFixture<LibrosListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibrosListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
