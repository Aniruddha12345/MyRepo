import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {MatRadioModule} from '@angular/material/radio';
import { HttpClientModule } from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {RouterModule,Routes} from '@angular/router';
import {NgxSpinnerModule} from 'ngx-spinner'

import { LoginComponent } from './login/login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import {MainService} from './Service/MainService';
import { RegisterStudentComponent } from './register-student/register-student.component'

const homeRoutes: Routes = [
  {
    path:'',
    component : LoginComponent
  },

  {
    path:'login',
    component : LoginComponent
  },
 
  {
    path:'adminHome',
    component : AdminHomeComponent
  },
  {
    path:'studentHome',
    component : StudentHomeComponent
  },
  {
    path:'registerStudent',
    component : RegisterStudentComponent
  }  
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHomeComponent,
    StudentHomeComponent,
    RegisterStudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    MatRadioModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    NgxSpinnerModule,
    RouterModule.forRoot(homeRoutes)
  ],
  providers: [MainService],
  bootstrap: [AppComponent]
})
export class AppModule { }
