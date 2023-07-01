import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NinthChapterComponent } from './ninth-chapter.component';

describe('NinthChapterComponent', () => {
  let component: NinthChapterComponent;
  let fixture: ComponentFixture<NinthChapterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NinthChapterComponent]
    });
    fixture = TestBed.createComponent(NinthChapterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
