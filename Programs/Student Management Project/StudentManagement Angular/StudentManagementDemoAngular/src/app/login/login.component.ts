import { Component, OnInit } from '@angular/core';
import {MainService} from '../Service/MainService'



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {




  constructor(private mainService:MainService) { }

  ngOnInit() {
   
    this.mainService.validateLogin();

  }

  
}
