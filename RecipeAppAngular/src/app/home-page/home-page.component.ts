import { Component, OnInit, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(public http: Http)  { }

  ngOnInit() {
    this.http.post(environment.context + 'users/login',  { withCredentials: true }).subscribe(
      (successResponse) => {
          // this.reimbursements = successResponse.json();
          alert('SUCCESS');

  },
      (failResponse) => {
          alert('FAILED');
  });


  }

}
