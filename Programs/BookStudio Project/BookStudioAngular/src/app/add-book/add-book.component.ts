import { Component, OnInit } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor(private http: Http) { }

  ngOnInit() {
  }

  //post web service call
  onClickSubmit(data: any) {
    this.http.post('http://localhost:8180/BookStudio/api/books/addBooks', data)
      .map((res: Response) => res.json())
      .subscribe(data => {
        console.log(data);
        //alert box with the name of the book
        alert(data.bk_name + ' added successfully ');
      });
  }
}
