import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ShowAllBooksComponent } from './show-all-books/show-all-books.component';

import { FormsModule } from '@angular/forms';
import { HttpModule} from '@angular/http';

import { RouterModule} from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';






@NgModule({
  declarations: [
    AppComponent,
    ShowAllBooksComponent,
    AddBookComponent


  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {
         path: 'showallbooks',
         component: ShowAllBooksComponent
      },
      {
        path: 'addbook',
        component: AddBookComponent
       }
       
   ])
    
  ],
  providers: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
