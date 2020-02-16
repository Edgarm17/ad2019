import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SociosListNameComponent } from './socios-list-name.component';

describe('SociosListNameComponent', () => {
  let component: SociosListNameComponent;
  let fixture: ComponentFixture<SociosListNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SociosListNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SociosListNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
