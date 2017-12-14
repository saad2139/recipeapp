import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Category } from '../entities/Category';
import { environment } from '../../environments/environment';


@Injectable()
export class CategoriesService {

  constructor(private http: Http) {
  }

  url = environment.context + 'categories';
  categories: Array<Category>;
  currentCategory: Category;

  getCategories() {
    this.http.get(environment.context + 'categories', { withCredentials: true }).subscribe(
      (successResponse) => {
        this.categories = successResponse.json();
      },
      (failResponse) => {
        alert('Failed to retrieve desired recipe ID.');
      });
  }
}
