import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { StartComponent } from './components/start/start.component';
import { PrologueComponent } from './components/prologue/prologue.component';
import { AccessGuardService } from './services/guard/access-guard.service';
import { FirstChapterComponent } from './components/first-chapter/first-chapter.component';

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
    canActivate: [AccessGuardService]
  },
  {
    path: 'prologue',
    component: PrologueComponent,
    canActivate: [AccessGuardService]
  },
  {
    path: 'first_chapter',
    component: FirstChapterComponent,
    canActivate: [AccessGuardService]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
