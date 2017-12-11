import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { CategoriesService } from '../services/categories.service';
import { Category } from '../entities/Category';
import { Ingredient } from '../entities/Ingredient';
import { environment } from '../../environments/environment';


@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {
  difficulty = [
    { difficulty_id: 1, difficulty_name: 'Easy'},
    { difficulty_id: 2, difficulty_name: 'Medium'},
    { difficulty_id: 3, difficulty_name: 'Hard'},
    { difficulty_id: 4, difficulty_ame: 'Expert'}];
  ingredientsList: Array<Ingredient> = [];
  newIngredient = new Ingredient();
  recipeCategories: Array<Category> = [];
  categoryOptions: Array<Category> = [];

  // recipe name
  recipe = {
    recipeName: ' ',
    recipeImage: Blob,
    cookingTime: 0,
    directions: '',
    upvotes: 0,
    flag: 0,
    difficulty: this.difficulty[0],
    // difficulty: {difficultyId: 0, difficultyName: ' '},
    creator: {user_id: 1, username: 'therealgordon', password: 'testing',	email: 'GordonR@gmail.com',
    first_name: 'Gordon', last_name: 'Ramsay', role_id: 0 },
    ingredients: this.ingredientsList,
    categories:  this.recipeCategories,
  };

  addMoreIngredients = false;
  submitted = false;
  listOfCategories = [];

  constructor(private categoriesService: CategoriesService, private router: Router, private http: Http) { }

  ngOnInit() {
    this.categoriesService.getCategories().
    subscribe(responseCategories => this.listOfCategories = responseCategories);
  }

  get diagnostic() {
    return JSON.stringify(this.recipe);
  }

  onSubmit() {
    this.submitted = true;
    this.http.post(environment.context + 'recipe/addRecipe', this.recipe, {withCredentials: true})
      .subscribe((succResp) => {
        if (succResp.text() !== '') {
          alert('added recipe successfully');
        } else {
          alert('added recipe successfully');
        }
      });
  }

  addIngredient() {
    alert('clicked button');
    this.recipe.ingredients.push(this.newIngredient);
    this.newIngredient = new Ingredient();
    this.addMoreIngredients = true;
  }
}
