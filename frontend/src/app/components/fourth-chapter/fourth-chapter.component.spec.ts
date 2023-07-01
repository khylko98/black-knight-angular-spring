import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FourthChapterComponent } from './fourth-chapter.component';

describe('FourthChapterComponent', () => {
  let component: FourthChapterComponent;
  let fixture: ComponentFixture<FourthChapterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FourthChapterComponent]
    });
    fixture = TestBed.createComponent(FourthChapterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
