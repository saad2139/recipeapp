import { Component } from '@angular/core';
import { Category } from '../entities/Category';
import { CategoriesService } from '../services/categories.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  category = { categoryName: ' ' };

  categories: Array<Category>;

  constructor(private categoriesService: CategoriesService, private router: Router) { }

  ngOnInit() {
    this.categoriesService.getCategories();
  }

  checkUser() {
    if (localStorage.getItem('currentUser') === '') return false;
    else return true;
  }

  moveToCategory(category: Category) {
    this.categoriesService.currentCategory = category;
    this.router.navigate(['/browseRecipes']);
  }
}
