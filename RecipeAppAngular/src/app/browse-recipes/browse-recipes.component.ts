import { Component, OnInit, Inject } from '@angular/core';
import { RecipeViewerService } from '../services/recipe-viewer.service';
import { environment } from '../../environments/environment';
import { Recipe } from '../entities/Recipe';
import { Http } from '@angular/http';
import { Category } from '../entities/Category';
import { CategoriesService } from '../services/categories.service';

@Component({
  selector: 'app-browse-recipes',
  templateUrl: './browse-recipes.component.html',
  styleUrls: ['./browse-recipes.component.css']
})
export class BrowseRecipesComponent implements OnInit {
  
  constructor(public http: Http, @Inject(RecipeViewerService) private rv: RecipeViewerService, private cs: CategoriesService) { }
  
    recipes: Array<Recipe>;
  
    ngOnInit() {
  
      this.http.get(environment.context + 'recipe/allRecipes', { withCredentials: true })
        .subscribe((succResp) => {
          this.recipes = succResp.json();
          this.recipes.sort((r1, r2) => r2.upvotes - r1.upvotes);

          if (this.cs.currentCategory) {
            this.sortByCategory(this.cs.currentCategory);
            this.cs.currentCategory = null;
          }
        });


    }

    sortByName() {
      this.recipes.sort((a,b) => a.recipeName > b.recipeName ? 1: -1);
    }

    sortByLikes() {
      this.recipes.sort((a,b) => b.upvotes - a.upvotes);
    }

    sortByDifficulty() {
      this.recipes.sort((a,b) => a.difficulty.id > b.difficulty.id ? 1 : -1);
    }

    sortByCategory(category: Category) {
        let desiredId = category.categoryId;

        
    }
    

}
