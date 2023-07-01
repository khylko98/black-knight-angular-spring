import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { AuthReq } from 'src/app/models/auth-req';
import { PlayerRegistrationReq } from 'src/app/models/player-registration-req';
import { AuthService } from 'src/app/services/auth/auth.service';
import { PlayerService } from 'src/app/services/player/player.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [MessageService],
})
export class RegistrationComponent {
  playerRegistrationReq: PlayerRegistrationReq = {};
  errorMessage = '';

  constructor(
    private messageService: MessageService,
    private playerService: PlayerService,
    private authService: AuthService,
    private router: Router
  ) {}

  login() {
    this.router.navigate(['']);
  }

  registration() {
    this.errorMessage = '';
    this.playerService.registerPlayer(this.playerRegistrationReq).subscribe({
      next: () => {
        const authReq: AuthReq = {
          username: this.playerRegistrationReq.username,
          password: this.playerRegistrationReq.password,
        };
        this.authService.login(authReq).subscribe({
          next: (authResponse) => {
            localStorage.setItem('token', authResponse.token);
            this.router.navigate(['start']);
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
      },
    });
  }
}
