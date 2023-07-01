import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EighthChapterComponent } from './eighth-chapter.component';

describe('EighthChapterComponent', () => {
  let component: EighthChapterComponent;
  let fixture: ComponentFixture<EighthChapterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EighthChapterComponent]
    });
    fixture = TestBed.createComponent(EighthChapterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
