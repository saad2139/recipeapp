import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { Http } from '@angular/http';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  closeResult: string;
  register= {
    first_name: '',
    last_name: '',
    username: '',
    password: '',
    email: '',
  };
  loading = false;

  constructor(private modalService: NgbModal, private router: Router, private http: Http) { }

  ngOnInit() {
  }
  open(content) {
    this.modalService.open(content);
  }
  submit() {
    this.http.post(environment.context + 'users/register', this.register, { withCredentials: true })
      .subscribe((succResp) => {
        if (succResp.text() !== '') {
          alert('Registration Success');
        } else {
          alert('failed to login');
        }
      });
  }

  checkUser() {
    if (localStorage.getItem('currentUser') === '') {
      return false;
    }else {
      return true;
    }
  }
}

