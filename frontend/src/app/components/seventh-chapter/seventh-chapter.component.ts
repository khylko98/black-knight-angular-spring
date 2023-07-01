import { Component, OnInit } from '@angular/core';
import { GameRes } from 'src/app/models/game-res';
import { MessageService } from 'primeng/api';
import { GameService } from 'src/app/services/game/game.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seventh-chapter',
  templateUrl: './seventh-chapter.component.html',
  styleUrls: ['./seventh-chapter.component.css'],
  providers: [MessageService],
})
export class SeventhChapterComponent implements OnInit {
  chapterData: Array<GameRes> = [];
  errorMessage = '';
  num = 7;
  part = 1;
  readonly maxParts = 10;

  constructor(
    private gameService: GameService,
    private messageService: MessageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchData();
  }

  private fetchData() {
    this.errorMessage = '';
    this.gameService
      .findChapter('chapter', this.num.toString(), this.part.toString())
      .subscribe({
        next: (data) => {
          data.talkOptionVisible = true;
          data.talkOptionResultVisible = false;
          this.chapterData.push(data);
        },
        error: (err) => {
          if (err.error.message == undefined) {
            this.errorMessage = 'Server Error';
          } else {
            this.errorMessage = err.error.message;
          }
          this.messageService.add({
            key: 'tc',
            severity: 'error',
            summary: 'Error',
            detail: this.errorMessage,
          });
        },
      });
  }

  talkOption() {
    this.part = this.part + 1;
    this.chapterData[this.chapterData.length - 1].talkOptionVisible = false;
    this.chapterData[this.chapterData.length - 1].talkOptionResultVisible =
      true;
    this.fetchData();
  }

  public get toNextChapterCheck(): boolean {
    return this.part > this.maxParts;
  }

  toNextChapter() {
    this.router.navigate(['eighth_chapter']);
  }
}
