import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeventhChapterComponent } from './seventh-chapter.component';

describe('SeventhChapterComponent', () => {
  let component: SeventhChapterComponent;
  let fixture: ComponentFixture<SeventhChapterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SeventhChapterComponent]
    });
    fixture = TestBed.createComponent(SeventhChapterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
