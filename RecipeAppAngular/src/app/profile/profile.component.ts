import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
import { Recipe } from '../entities/Recipe';
import { RecipeViewerService } from '../services/recipe-viewer.service';
import { ProfileService } from '../services/profile.service';
import { OnChanges, DoCheck } from '@angular/core/src/metadata/lifecycle_hooks';
import { User } from '../entities/User';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit, DoCheck {



  currentUser: any;
  viewProfile: any;
  userRecipes: Array<Recipe>;
  constructor(public http: Http, public ps: ProfileService, public rv: RecipeViewerService) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.viewProfile = this.currentUser;
    this.http.get(environment.context + 'recipe/allRecipes', { withCredentials: true })
      .subscribe((succResp) => {
        this.userRecipes = succResp.json();
        console.log(this.userRecipes);
      });
    this.http.get(environment.context + 'users/' + this.ps.userId, { withCredentials: true }).subscribe(
      (successResponse) => {
        this.viewProfile = successResponse.json();
      },
      (failResponse) => {
        this.viewProfile = this.currentUser;
      });
  }
  ngDoCheck() {
}

checkSameUser() {
  const current = <User>JSON.parse(localStorage.getItem('currentUser'));
  if (current.id === this.ps.userId) {
    return false;
  }else {
    return true;
  }
}
}
