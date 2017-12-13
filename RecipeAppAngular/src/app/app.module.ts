import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';

import { appRoutes } from './routes';
import { AddRecipeComponent } from './add-recipe/add-recipe.component';
import { RecipeComponent } from './recipe/recipe.component';
import { CategoriesService } from './services/categories.service';
import { RegistrationComponent } from './registration/registration.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RecipeFilterPipe } from './pipes/recipe-filter.pipe';
import { RecipeViewerComponent } from './recipe-viewer/recipe-viewer.component';
import { RecipeViewerService } from './services/recipe-viewer.service';
import { DirectionsPipe } from './directions-pipe';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    FormsModule,
  ],
  declarations: [
    AppComponent,
    NavComponent,
    AddRecipeComponent,
    RecipeComponent,
    RegistrationComponent,
    HomePageComponent,
    LoginComponent,
    ProfileComponent,
    RecipeFilterPipe,
    RecipeViewerComponent,
    DirectionsPipe,
   ],
  providers: [
    CategoriesService,
    RecipeViewerService,
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
