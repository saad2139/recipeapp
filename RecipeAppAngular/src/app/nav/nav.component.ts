import { Component } from '@angular/core';
import { Category } from '../entities/Category';
import { CategoriesService } from '../services/categories.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  category = { categoryName: ' ' };

  categories: Array<Category>;

  constructor(private categoriesService: CategoriesService) { }
  ngOnInit() {
    this.categoriesService.getCategories().subscribe(responseCategories => this.categories = responseCategories);
  }
}
