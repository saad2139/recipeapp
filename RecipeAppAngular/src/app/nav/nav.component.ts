import { Component, OnInit, Inject } from '@angular/core';
import { Category } from '../entities/Category';
import { CategoriesService } from '../services/categories.service';
import { Router } from '@angular/router';
import { ProfileComponent } from '../profile/profile.component';
import { ProfileService } from '../services/profile.service';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  category = { categoryName: ' ' };
  loggedInUser: any;
  categories: Array<Category>;

  constructor(private categoriesService: CategoriesService, private router: Router,
    @Inject(ProfileService) private ps: ProfileService) { }

  ngOnInit() {
    this.categoriesService.getCategories();
  }

  checkUser() {
    if (localStorage.getItem('currentUser') === '') {

      return false;
    } else {
      this.loggedInUser = JSON.parse(localStorage.getItem('currentUser'));
      return true;
    }
  }

  moveToCategory(category: Category) {
    this.categoriesService.currentCategory = category;
    this.router.navigate(['/browseRecipes']);
  }
}
