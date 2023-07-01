import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EpilogueComponent } from './epilogue.component';

describe('EpilogueComponent', () => {
  let component: EpilogueComponent;
  let fixture: ComponentFixture<EpilogueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EpilogueComponent]
    });
    fixture = TestBed.createComponent(EpilogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
