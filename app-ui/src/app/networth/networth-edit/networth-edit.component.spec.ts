import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NetworthEditComponent } from './networth-edit.component';

describe('NetworthEditComponent', () => {
  let component: NetworthEditComponent;
  let fixture: ComponentFixture<NetworthEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NetworthEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NetworthEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
