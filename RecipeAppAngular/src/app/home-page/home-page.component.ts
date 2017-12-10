import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(public http: Http)  { }

  ngOnInit() {
    this.http.post('localhost:8080/RecipeApp/users/login',  { withCredentials: true }).subscribe(
      (successResponse) => {
          // this.reimbursements = successResponse.json();
          alert('SUCCESS');
          
  },
      (failResponse) => {
          alert('FAILED');
  });

  this.http.get('localhost:8080/RecipeApp/recipes',  { withCredentials: true }).subscribe(
    (successResponse) => {
        // this.reimbursements = successResponse.json();
        
        
},
    (failResponse) => {
        
});

  }

}
