import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecondChapterComponent } from './second-chapter.component';

describe('SecondChapterComponent', () => {
  let component: SecondChapterComponent;
  let fixture: ComponentFixture<SecondChapterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SecondChapterComponent]
    });
    fixture = TestBed.createComponent(SecondChapterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
