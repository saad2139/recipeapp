import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser = {};
  userRecipes = {};
  constructor(private http: Http) { }

  ngOnInit() {
   this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
   this.http.post(environment.context + 'users/register', this.currentUser, { withCredentials: true })
   .subscribe((succResp) => {
     if (succResp.text() !== '') {
       alert('Here are the user recipes');
     } else {
       alert('failed to get user recipes');
     }
   });
  }
}
