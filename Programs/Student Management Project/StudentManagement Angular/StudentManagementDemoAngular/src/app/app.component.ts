import { Component } from '@angular/core';
import { MainService } from './Service/MainService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'StudentManagementDemoAngular';
  constructor(private mainService:MainService) {}
}
