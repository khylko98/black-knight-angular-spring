import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { StartComponent } from './components/start/start.component';
import { PrologueComponent } from './components/prologue/prologue.component';
import { AccessGuardService } from './services/guard/access-guard.service';
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

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'registration',
    component: RegistrationComponent,
  },
  {
    path: 'start',
    component: StartComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'prologue',
    component: PrologueComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'first_chapter',
    component: FirstChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'second_chapter',
    component: SecondChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'third_chapter',
    component: ThirdChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'fourth_chapter',
    component: FourthChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'fifth_chapter',
    component: FifthChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'sixth_chapter',
    component: SixthChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'seventh_chapter',
    component: SeventhChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'eighth_chapter',
    component: EighthChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'ninth_chapter',
    component: NinthChapterComponent,
    canActivate: [AccessGuardService],
  },
  {
    path: 'epilogue',
    component: EpilogueComponent,
    canActivate: [AccessGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
