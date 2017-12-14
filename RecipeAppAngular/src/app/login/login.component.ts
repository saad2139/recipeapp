import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
import { ProfileService } from '../services/profile.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: '';
  password: '';
  sendUser: {};

  credentials = {
    username: '',
    password: ''
  };

  constructor(public http: Http, private router: Router,  @Inject(ProfileService) private ps: ProfileService) { }

  ngOnInit() {

  }

  logout() {
    localStorage.setItem('currentUser', '');
    this.router.navigate(['/home']);
  }

  checkUser() {
    if (localStorage.getItem('currentUser') === '') {
      return false;
    } else {
      return true;
    }
  }

  login() {
    this.credentials.username = this.username;
    this.credentials.password = this.password;
    console.log(this.credentials);

    this.http.post(environment.context + 'users/login', this.credentials, { withCredentials: true }).subscribe(
      (successResponse) => {
        if (successResponse.text() !== '') {
          console.log('login successful. Saving user to local storage: ' + successResponse.text());
          localStorage.setItem('currentUser', JSON.stringify(successResponse.json()));
          this.sendUser = JSON.parse(localStorage.getItem('currentUser'));
          this.ps.goToRecipe(this.sendUser);
        } else {
          alert('Credentials incorrect.');
        }
  },
      (failResponse) => {
        alert('Failed to establish connection with server.');
      });

  }
}
