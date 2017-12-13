import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: '';
  password: '';

  credentials = {
    username: '',
    password: ''
  };

  constructor(public http: Http, private router: Router) { }

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
          this.router.navigate(['/profile']);
        } else {
          alert('Credentials incorrect.');
        }
<<<<<<< HEAD
      },
=======
        else alert("Credentials incorrect.")
  },
>>>>>>> master
      (failResponse) => {
        alert('Failed to establish connection with server.');
      });

  }
}
