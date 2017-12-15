import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Category } from '../entities/Category';
import { environment } from '../../environments/environment';


@Injectable()
export class CategoriesService {

  constructor(public http: Http) {
  }

  url = 'http://localhost:8080/Recipe-App/categories';
  categories: Array<Category>;
  currentCategory: Category;

  getCategories2() {
    return this.http.get(this.url).map((response: Response) => response.json());
  }

  getCategories() {
    this.http.get('http://localhost:8080/Recipe-App/categories', { withCredentials: true }).subscribe(
      (successResponse) => {
        this.categories = successResponse.json();
      },
      (failResponse) => {
        alert('Failed to retrieve desired recipe ID.');
      });
  }
}
