import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
import { User } from '../entities/User';
import { Recipe } from '../entities/Recipe';
import { RecipeViewerService } from '../services/recipe-viewer.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(public http: Http, @Inject(RecipeViewerService) private rv: RecipeViewerService) { }

  recipes: Array<Recipe>;

  ngOnInit() {

    this.http.get(environment.context + 'recipe/allRecipes', { withCredentials: true })
      .subscribe((succResp) => {
        this.recipes = succResp.json();
        this.recipes.sort((r1, r2) => r2.upvotes - r1.upvotes);
        console.log();
      });
  }

  checkUser() {

    if (localStorage.getItem('currentUser') === '') {

      return false;
    } else {
      // let currentUser = <User>JSON.parse(localStorage.getItem('currentUser'));
      // this.followingList = currentUser.following_list;
      // console.log(JSON.parse(localStorage.getItem('currentUser')));
      // console.log(currentUser);
      // console.log(this.followingList);
      return true;
    }
  }


}
