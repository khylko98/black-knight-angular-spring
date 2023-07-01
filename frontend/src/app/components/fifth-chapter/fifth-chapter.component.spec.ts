import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FifthChapterComponent } from './fifth-chapter.component';

describe('FifthChapterComponent', () => {
  let component: FifthChapterComponent;
  let fixture: ComponentFixture<FifthChapterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FifthChapterComponent]
    });
    fixture = TestBed.createComponent(FifthChapterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
