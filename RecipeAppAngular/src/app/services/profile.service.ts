import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';

@Injectable()
export class ProfileService {

  userId: Number;
  constructor(private http: Http, private router: Router) { }

  ngOnInit() {
  }

  goToRecipe(user) {
    this.userId = user;
    console.log(this.userId);
    this.router.navigate(['/profile']);
  }
}
