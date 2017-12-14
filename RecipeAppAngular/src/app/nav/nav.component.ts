import { Component, OnInit, Inject } from '@angular/core';
import { Category } from '../entities/Category';
import { CategoriesService } from '../services/categories.service';
<<<<<<< HEAD
import { Router } from '@angular/router';
=======
import { ProfileComponent} from '../profile/profile.component';
import { ProfileService } from '../services/profile.service';

>>>>>>> master

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  category = { categoryName: ' ' };
  loggedInUser: any;
  categories: Array<Category>;

<<<<<<< HEAD
  constructor(private categoriesService: CategoriesService, private router: Router) { }

  ngOnInit() {
    this.categoriesService.getCategories();
=======
  constructor(private categoriesService: CategoriesService, @Inject(ProfileService) private ps: ProfileService) { }
  ngOnInit() {
    this.categoriesService.getCategories().subscribe(responseCategories => this.categories = responseCategories);
    if (localStorage.getItem('currentUser') !== undefined) {
      this.loggedInUser = JSON.parse(localStorage.getItem('currentUser'));
    }
>>>>>>> master
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
