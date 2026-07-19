import { Component } from '@angular/core';
import { UserModel } from '../../models/user.model';
import { NgOptimizedImage } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-signin',
  imports: [NgOptimizedImage, RouterLink, FormsModule],
  templateUrl: './signin.html',
  styleUrl: './signin.css',
})
export class Signin {
  logoUrl: string = '/images/Logo.png';
  logoAlt: string = 'Logo sito';
  user: UserModel = new UserModel();

  onSignin(user: UserModel) {
    console.log(this.user);
    //TODO CHIAMATA BE CON LOGICA
  }
}
