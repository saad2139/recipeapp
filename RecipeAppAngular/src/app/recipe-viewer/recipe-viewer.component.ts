import { Component, OnInit, Inject } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http } from '@angular/http';
import { RecipeViewerService } from '../services/recipe-viewer.service';
import { Recipe } from '../entities/Recipe';

@Component({
  selector: 'app-recipe-viewer',
  templateUrl: './recipe-viewer.component.html',
  styleUrls: ['./recipe-viewer.component.css']
})
export class RecipeViewerComponent implements OnInit {

  constructor(public http: Http, @Inject(RecipeViewerService) private rv: RecipeViewerService) { }
  id: number;
  recipe: Recipe;

  ngOnInit() {
    this.http.get(environment.context + 'recipe/' + this.rv.id,  { withCredentials: true }).subscribe(
      (successResponse) => {
        this.recipe = successResponse.json();
        console.log(this.recipe);
      },
      (failResponse) => {
        alert('Failed to retrieve desired recipe ID.');
      });
  }

}
