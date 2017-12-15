import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { Category } from '../entities/Category';
import { environment } from '../../environments/environment';


@Injectable()
export class CategoriesService {

  constructor(private http: Http) {
  }

  // url = 'http://localhost:8080/Recipe-App/categories';
  url = environment.context + 'categories';

  getCategories() {
    return this.http.get(this.url).map((response: Response) => response.json());
  }
}
