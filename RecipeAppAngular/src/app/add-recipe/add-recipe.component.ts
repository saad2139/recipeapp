import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {

  // recipe name
  recipeName =  ' ';
  recipeImage;
  cookingTime;
  directions;
  difficulty;

  constructor(private router: Router, private http: Http) { }

  ngOnInit() {
  }

  submit() {

  }
}
