import { Component, OnInit } from '@angular/core';

import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map'

@Component({
  selector: 'app-show-all-books',
  templateUrl: './show-all-books.component.html',
  styleUrls: ['./show-all-books.component.css']
})
export class ShowAllBooksComponent implements OnInit {

  private apiUrl = 'http://localhost:8180/BookStudio/api/books/getAllBooks/';
  data: any;

  constructor(private http: Http) {
    console.log('These are the Books');
  }

  ngOnInit() {
    this.getBooks();
  }

  //get web service call
  getBooks() {
    this.http.get(this.apiUrl)
      .map((res: Response) => res.json()).subscribe(data => {
        console.log(data);
        this.data = data
      });
  }

  //get web service call with wildcard search
  onClickSubmit(data1: any) {
    console.log(data1);
    this.http.get('http://localhost:8180/BookStudio/api/books/getBookDetailsByName/' + data1.bk_name)
      .map((res: Response) => res.json())
      .subscribe(data => {
        console.log(data);
        this.data = data;
        alert("searched results for " + data1.bk_name + " are :")
      });
  }

  //put web service call
  update(book: any) {
    this.http.put('http://localhost:8180/BookStudio/api/books/updateIssueFlag/', book)
      .map((res: Response) => res.json())
      .subscribe(book => {
        console.log(book);
        //alert box with the name of the book
        alert(book.bk_name + ' issued successsfully.')
        //to load the first component
        this.getBooks();
      });
  }

  //delete web service call
  delete(bk_id: any) {
    this.http.delete('http://localhost:8180/BookStudio/api/books/deleteBookById/' + bk_id)
      .map((res: Response) => res.json())
      .subscribe(bk_id => {
        console.log(bk_id);
        alert('Book deleted successfully.')
        this.getBooks();
      });

  }
}
