import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  allRecipes;

  constructor(public http: Http)  { }

  ngOnInit() {
    this.http.get(environment.context + 'recipe/allRecipes', { withCredentials: true }).subscribe(
      (successResponse) => {
        this.allRecipes = successResponse.json();
        console.log(this.allRecipes);          
  },
      (failResponse) => {
          
  });
  }


  }


