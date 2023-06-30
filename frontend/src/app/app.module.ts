import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ToastModule } from 'primeng/toast';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BackgroundComponent } from './components/background/background.component';
import { LoginComponent } from './components/login/login.component';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';

@NgModule({
  declarations: [AppComponent, BackgroundComponent, LoginComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ToastModule,
    ButtonModule,
    PasswordModule,
    InputTextModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
