import { Component, OnInit } from '@angular/core';
import {MainService} from '../Service/MainService'

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent implements OnInit {

  constructor(private mainService:MainService) { }

  ngOnInit() {
  }

}
