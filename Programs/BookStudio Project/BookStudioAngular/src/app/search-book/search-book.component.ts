import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/map'

@Component({
  selector: 'app-search-book',
  templateUrl: './search-book.component.html',
  styleUrls: ['./search-book.component.css']
})
export class SearchBookComponent implements OnInit {

  data;
  constructor(private http: Http, private route: Router) { }

  ngOnInit() {
  }


  onClickSubmit(data1: any) {
    console.log(data1);
    this.http.get('http://localhost:8180/BookStudio/api/books/getBookDetailsByName/'+data1.bk_name)
      .map((res: Response) => res.json())
      .subscribe(data => {
        console.log(data);
        this.data=data;
        alert("searched results for "+data1.bk_name+" are :")
      });





  }

}
