import { Component } from '@angular/core';
import { UserModel } from '../../models/user.model';
import { NgOptimizedImage } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { RegexService } from '../../services/regex-service';

@Component({
  selector: 'app-reset-psw',
  imports: [NgOptimizedImage, RouterLink, FormsModule],
  templateUrl: './reset-psw.html',
  styleUrl: './reset-psw.css',
})
export class ResetPsw {
  logoUrl: string = '/images/Logo.png';
  logoAlt: string = 'Logo sito';
  user: UserModel = new UserModel();
  constructor(public regexService: RegexService){}


  onResetPsw(user: UserModel) {
    console.log(this.user);
    //TODO CHIAMATA BE CON LOGICA
  }
}
