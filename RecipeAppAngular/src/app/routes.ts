import { Routes } from '@angular/router';
import { AddRecipeComponent } from './add-recipe/add-recipe.component';
import { RecipeComponent } from './recipe/recipe.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProfileComponent } from './profile/profile.component';

export const appRoutes: Routes = [
  // routes go here
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'home',
    component: HomePageComponent
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


