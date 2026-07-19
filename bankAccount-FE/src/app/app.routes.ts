import { Routes } from '@angular/router';
import { Dashboard } from './pages/dashboard/dashboard';
import { Profile } from './pages/profile/profile';
import { Transaction } from './pages/transaction/transaction';
import { Login } from './pages/login/login';
import { Signin } from './pages/signin/signin';
import { ResetPsw } from './pages/reset-psw/reset-psw';

export const routes: Routes = [
  {
    path: '',
    component: Login,
  },
  {
    path: 'signin',
    component: Signin,
  },
  {
    path: 'reset-password',
    component: ResetPsw,
  },
  {
    path: 'dashboard',
    component: Dashboard,
  },
  {
    path: 'profile',
    component: Profile,
  },
  {
    path: 'transactions',
    component: Transaction,
  },
];
