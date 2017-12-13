import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Category } from '../entities/Category';
import { Recipe } from '../entities/Recipe';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';


@Injectable()
export class RecipeViewerService {

    id: Number;

  constructor(private http: Http, private router: Router) {

  }

  ngOnInit() {
      
  }

  navigateToRecipe(id) {
    console.log(id);
    this.id = id;
    this.router.navigate(['/viewRecipe/']);
  }
}
