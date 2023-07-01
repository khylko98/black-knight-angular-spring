import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ToastModule } from 'primeng/toast';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BackgroundComponent } from './components/background/background.component';
import { LoginComponent } from './components/login/login.component';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { RegistrationComponent } from './components/registration/registration.component';
import { StartComponent } from './components/start/start.component';
import { ImageModule } from 'primeng/image';
import { Card, CardModule } from 'primeng/card';
import { PrologueComponent } from './components/prologue/prologue.component';
import { HttpInterceptorService } from './services/interceptor/http-interceptor.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { FirstChapterComponent } from './components/first-chapter/first-chapter.component';
import { SecondChapterComponent } from './components/second-chapter/second-chapter.component';
import { ThirdChapterComponent } from './components/third-chapter/third-chapter.component';
import { FourthChapterComponent } from './components/fourth-chapter/fourth-chapter.component';
import { FifthChapterComponent } from './components/fifth-chapter/fifth-chapter.component';
import { SixthChapterComponent } from './components/sixth-chapter/sixth-chapter.component';
import { SeventhChapterComponent } from './components/seventh-chapter/seventh-chapter.component';
import { EighthChapterComponent } from './components/eighth-chapter/eighth-chapter.component';
import { NinthChapterComponent } from './components/ninth-chapter/ninth-chapter.component';
import { EpilogueComponent } from './components/epilogue/epilogue.component';

@NgModule({
  declarations: [AppComponent, BackgroundComponent, LoginComponent, RegistrationComponent, StartComponent, PrologueComponent, FirstChapterComponent, SecondChapterComponent, ThirdChapterComponent, FourthChapterComponent, FifthChapterComponent, SixthChapterComponent, SeventhChapterComponent, EighthChapterComponent, NinthChapterComponent, EpilogueComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ToastModule,
    ButtonModule,
    PasswordModule,
    InputTextModule,
    ImageModule,
    CardModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    },
    MessageService,
    ConfirmationService
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
