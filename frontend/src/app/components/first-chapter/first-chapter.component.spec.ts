import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstChapterComponent } from './first-chapter.component';

describe('FirstChapterComponent', () => {
  let component: FirstChapterComponent;
  let fixture: ComponentFixture<FirstChapterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FirstChapterComponent]
    });
    fixture = TestBed.createComponent(FirstChapterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
