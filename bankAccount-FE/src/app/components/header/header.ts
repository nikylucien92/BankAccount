import { Component, OnInit, signal } from '@angular/core';
import {
  ActivatedRoute,
  NavigationEnd,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { filter } from 'rxjs';
import { NgOptimizedImage } from '@angular/common';
import { HeaderItem } from '../../models/header-item.model';

@Component({
  selector: 'app-header',
  imports: [NgOptimizedImage, RouterLink, RouterLinkActive],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header implements OnInit {
  title = signal('');
  logoLg: string = '/images/Logo.png';
  logoSm: string = '/icons/logo_icon.svg';
  logoAlt: string = 'Logo sito';
  headerItems: HeaderItem[] = [
    {
      title: 'Dashboard',
      iconDefault: '/icons/home_grey.svg',
      iconActive: '/icons/home_active.svg',
      path: '/dashboard',
    },
    {
      title: 'Transazioni',
      iconDefault: '/icons/transactions_grey.svg',
      iconActive: '/icons/transactions_active.svg',
      path: '/transactions',
    },
    {
      title: 'Conti',
      iconDefault: '/icons/accounts_grey.svg',
      iconActive: '/icons/accounts_active.svg',
      path: '/accounts',
    },
    {
      title: 'Le mie carte',
      iconDefault: '/icons/cards_grey.svg',
      iconActive: '/icons/cards_active.svg',
      path: '/cards',
    },
    {
      title: 'Prestiti',
      iconDefault: '/icons/loans_grey.svg',
      iconActive: '/icons/loans_active.svg',
      path: '/loans',
    },
    {
      title: 'Impostazioni',
      iconDefault: '/icons/settings_grey.svg',
      iconActive: '/icons/settings_active.svg',
      path: '/settings',
    },
  ];

  constructor(
    public readonly activatedRoute: ActivatedRoute,
    public readonly router: Router, //quando si passa da una route all'altra, router emette degli eventi
  ) {}

  ngOnInit(): void {
    this.setPageTitle();
    //NavigationEnd evento che angular emette quando la navigazione è terminata correttamente
    this.router.events.pipe(filter((event) => event instanceof NavigationEnd)).subscribe(() => {
      this.setPageTitle();
    });
  }

  setPageTitle(): void {
    let currentRoute = this.activatedRoute; //route attuale
    while (currentRoute.firstChild) {
      currentRoute = currentRoute.firstChild;
    }
    const routeTitle = currentRoute.snapshot.title; //titolo della route "finale"
    this.title.set(routeTitle ?? '');
  }
}
