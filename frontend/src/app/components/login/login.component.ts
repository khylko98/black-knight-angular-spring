import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { AuthReq } from 'src/app/models/auth-req';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [MessageService],
})
export class LoginComponent {
  authReq: AuthReq = {};
  errorMessage = '';

  constructor(
    private messageService: MessageService,
    private authService: AuthService,
    private router: Router
  ) {}

  login() {
    this.errorMessage = '';
    this.authService.login(this.authReq).subscribe({
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
  }

  registration() {
    this.router.navigate(['registration']);
  }
}
