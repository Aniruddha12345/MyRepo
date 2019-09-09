import { Component, OnInit } from '@angular/core';
import {MainService} from '../Service/MainService';


@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  constructor(private mainService:MainService) { }

  ngOnInit() {
  }

}
