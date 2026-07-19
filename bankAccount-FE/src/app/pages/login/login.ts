import { NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { UserModel } from '../../models/user.model';
import { RegexService } from '../../services/regex-service';

@Component({
  selector: 'app-login',
  imports: [NgOptimizedImage, RouterLink, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  logoUrl: string = '/images/Logo.png';
  logoAlt: string = 'Logo sito';
  user: UserModel = new UserModel();
  constructor(public regexService: RegexService, public router: Router){}

  onLogin(user: UserModel){
    console.log(this.user);
    //TODO CHIAMATA BE CON LOGICA
    this.router.navigateByUrl('/dashboard');
  }
}
