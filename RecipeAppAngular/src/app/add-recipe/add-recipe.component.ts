import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { CategoriesService } from '../services/categories.service';
import { Category } from '../entities/Category';


@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {
  category = {categoryId: ' ', categoryName: ' '};

  // recipe name
  recipeName =  ' ';
  recipeImage;
  cookingTime;
  categories = [];
  ingredients;
  directions;
  difficulty;

  constructor(private categoriesService: CategoriesService, private router: Router, private http: Http) { }

  ngOnInit() {
    this.categoriesService.getCategories().subscribe(responseCategories => this.categories = responseCategories);
  }

  submit() {
    alert('added new recipe');
  }
}
