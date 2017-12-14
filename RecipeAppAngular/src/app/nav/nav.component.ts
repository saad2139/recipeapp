import { Component, OnInit, Inject } from '@angular/core';
import { Category } from '../entities/Category';
import { CategoriesService } from '../services/categories.service';
import { ProfileComponent} from '../profile/profile.component';
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

  constructor(private categoriesService: CategoriesService, @Inject(ProfileService) private ps: ProfileService) { }
  ngOnInit() {
    this.categoriesService.getCategories().subscribe(responseCategories => this.categories = responseCategories);
    if (localStorage.getItem('currentUser') !== undefined) {
      this.loggedInUser = JSON.parse(localStorage.getItem('currentUser'));
    }
  }

  checkUser() {
    if (localStorage.getItem('currentUser') === '') return false;
    else return true;
  }
}
