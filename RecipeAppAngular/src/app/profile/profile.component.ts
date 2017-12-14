import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
import { Recipe } from '../entities/Recipe';
import { RecipeViewerService } from '../services/recipe-viewer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {



  currentUser = {};
  userRecipes: Array<Recipe>;
  constructor(private http: Http, private rv: RecipeViewerService) { }
  recipeFilter: any = { recipe: '' };

  ngOnInit() {
   this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
   this.http.get(environment.context + 'recipe/allRecipes', { withCredentials: true })
   .subscribe((succResp) => {
     this.userRecipes = succResp.json();
     console.log(this.userRecipes);
   });
  }
}
