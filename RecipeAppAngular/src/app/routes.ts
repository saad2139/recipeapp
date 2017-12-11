import { Routes } from '@angular/router';
import { AddRecipeComponent } from './add-recipe/add-recipe.component';
import { RecipeComponent } from './recipe/recipe.component';
import { RegistrationComponent } from './registration/registration.component';

export const appRoutes: Routes = [
  // routes go here
  {
    path: 'register',
    component: RegistrationComponent
  },
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


