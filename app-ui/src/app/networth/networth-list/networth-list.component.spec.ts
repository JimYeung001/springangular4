import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NetworthListComponent } from './networth-list.component';

describe('NetworthListComponent', () => {
  let component: NetworthListComponent;
  let fixture: ComponentFixture<NetworthListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NetworthListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NetworthListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
