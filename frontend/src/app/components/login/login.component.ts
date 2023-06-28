import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [MessageService],
})
export class LoginComponent {
  errorMessage = 'Error Message';

  constructor(private messageService: MessageService) {}

  showTopCenter() {
    this.messageService.add({
      key: 'tc',
      severity: 'error',
      summary: 'Error',
      detail: this.errorMessage,
    });
  }
}
