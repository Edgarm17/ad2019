import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SociosCreateComponent } from './socios-create.component';

describe('SociosCreateComponent', () => {
  let component: SociosCreateComponent;
  let fixture: ComponentFixture<SociosCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SociosCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SociosCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
