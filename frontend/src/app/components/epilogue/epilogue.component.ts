import { Component, OnInit } from '@angular/core';
import { GameRes } from 'src/app/models/game-res';
import { MessageService } from 'primeng/api';
import { GameService } from 'src/app/services/game/game.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-epilogue',
  templateUrl: './epilogue.component.html',
  styleUrls: ['./epilogue.component.css'],
  providers: [MessageService],
})
export class EpilogueComponent implements OnInit {
  epilogueData: Array<GameRes> = [];
  errorMessage = '';

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
    this.gameService.findChapter('epilogue', undefined, undefined).subscribe({
      next: (data) => {
        this.epilogueData.push(data);
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

  toNextChapter() {
    this.router.navigate(['start']);
  }
}
