import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { disableDebugTools, Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Blogs } from '../blogs';
import { BlogsService } from '../blogs.service';




@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  blogForm: Blogs = {
    id: 0,
    title: '',
    description: '',
    category:'',
  };
  constructor(private blogservice:BlogsService,private router:Router) { }

  ngOnInit(): void {
  }
  create(){
    if (this.blogForm.title=="" || this.blogForm.description=="" )
    {
      alert("Please enter both details")
    }
    else
    {

    this.blogservice.create(this.blogForm)
    .subscribe({
      next:(data) => {
        this.router.navigate(["/blogs/home"])
      },
      error:(err) => {
        console.log(err);
      }
    })
  }
   

    
  }

}
