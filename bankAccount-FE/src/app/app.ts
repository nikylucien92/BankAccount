import { Component, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('bankAccount-FE');
  constructor(public router: Router) {}

  get isHeaderShown() {
    return (
      this.router.url != '/' && this.router.url != '/login' && this.router.url != '/signin'
      && this.router.url != '/reset-password'
    );
  }
}
