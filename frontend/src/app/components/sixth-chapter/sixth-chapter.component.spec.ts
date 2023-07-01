import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SixthChapterComponent } from './sixth-chapter.component';

describe('SixthChapterComponent', () => {
  let component: SixthChapterComponent;
  let fixture: ComponentFixture<SixthChapterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SixthChapterComponent]
    });
    fixture = TestBed.createComponent(SixthChapterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
