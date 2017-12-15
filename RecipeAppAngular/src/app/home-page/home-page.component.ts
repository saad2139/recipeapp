import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
import { User } from '../entities/User';
import { Recipe } from '../entities/Recipe';
import { RecipeViewerService } from '../services/recipe-viewer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(public http: Http, @Inject(RecipeViewerService) public rv: RecipeViewerService, private router: Router) { }

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

    if (localStorage.getItem('currentUser') === '') return false;
    else return true;

  }




}
