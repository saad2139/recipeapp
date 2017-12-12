import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Category } from '../entities/Category';
import { Recipe } from '../entities/Recipe';
import { environment } from '../../environments/environment';


@Injectable()
export class RecipesService {

  constructor(private http: Http) {

  }

  ngOnInit() {
      this.getRecipes();
  }

  recipes: Array<Recipe>;
  

  getRecipes() {

  }
}
