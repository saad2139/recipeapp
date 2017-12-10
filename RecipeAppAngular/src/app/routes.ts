import { Routes } from '@angular/router';
import { AddRecipeComponent } from './add-recipe/add-recipe.component';
import { RecipeComponent } from './recipe/recipe.component';

export const appRoutes: Routes = [
  // routes go here
  {
    path: 'recipe',
    component: RecipeComponent,
    children: [
      {
        path: 'addRecipe',
        component: AddRecipeComponent
      }
    ]
  }
];
