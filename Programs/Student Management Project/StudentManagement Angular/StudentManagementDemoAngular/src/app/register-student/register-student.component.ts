import { Component, OnInit } from '@angular/core';
import {MainService} from '../Service/MainService';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.css']
})
export class RegisterStudentComponent implements OnInit {

  constructor(private mainService:MainService) { }

  ngOnInit() {

    this.mainService.validateRegistration();
  }

}
