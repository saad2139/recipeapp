import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { CategoriesService } from '../services/categories.service';
import { Category } from '../entities/Category';
import { Ingredient } from '../entities/Ingredient';
import { environment } from '../../environments/environment';
import { RecipeViewerService } from '../services/recipe-viewer.service';
import { Recipe } from '../entities/Recipe';
import { EventEmitter} from '@angular/core';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {

  difficulties = [
    {id: 1, difficulty_level: 'Easy'},
    {id: 2, difficulty_level: 'Medium'},
    {id: 3, difficulty_level: 'Hard'},
    {id: 4, difficulty_level: 'Expert'}];

  currentUser = {};
  newIngredient = new Ingredient();
  recipeCategories: Array<Category> = [];
  recipeIngredients: Array<Ingredient> = [];
  addedRecipe: Recipe;
  // user

  // recipe name
  recipe = {
    recipeName: ' ',
    image: null,
    cookingTime: 0,
    dateCreated: '',
    directions: ' ',
    upvotes: 0,
    flag: 0,
    difficulty: this.difficulties[0],
    creator: this.currentUser,
    // creator: {id: 162, username: 'bcrocker', password: 'cooking',
    //   email: 'betty@crocker.com', first_name: 'Betty', last_name: 'Croker', role_id: 1 },
    ingredients: this.recipeIngredients,
    categories: this.recipeCategories,
  };

  addMoreIngredients = false;
  submitted = false;
  listOfCategories = [];

  constructor(private categoriesService: CategoriesService, private router: Router, private http: Http) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.categoriesService.getCategories().
    subscribe(responseCategories => this.listOfCategories = responseCategories);
    // this.categoriesService.getCategories().subscribe(responseCategories => this.listOfCategories = responseCategories);
  }

  get diagnostic() {
    return JSON.stringify(this.recipe);
  }

  onSubmit() {
    this.submitted = true;
    alert(JSON.stringify(this.recipe));
    console.log(this.recipe.ingredients);

    this.http.post(environment.context + 'recipe/addRecipe', this.recipe, {withCredentials: true})
      .subscribe((succResp) => {
        if (succResp.text() !== '') {
          alert('added recipe successfully');
          this.addedRecipe = new Recipe();
          this.addedRecipe = succResp.json();
          console.log(succResp.json());
          this.router.navigate(['/viewRecipe/']); // added recipe component go to profile
        } else {
          alert('could not add recipe');
        }
      });
  }

  addIngredient() {
    this.recipe.ingredients.push(this.newIngredient);
    this.newIngredient = new Ingredient();
    this.addMoreIngredients = true;
  }
}
