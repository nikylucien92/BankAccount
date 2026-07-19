import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RegexService {
  emailRegex: RegExp = new RegExp(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g);
}
