import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Blogs } from '../blogs';
import { BlogsService } from '../blogs.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
blogForm:Blogs={
  id:0,
  title:'',
  description:'',
  category:'',
}
  constructor(private route:ActivatedRoute, private blogservice:BlogsService,private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((param) => {
      var id = Number(param.get('id'));
      this.getById(id);
    });

  }


  getById(id: number) {
    this.blogservice.getbyid(id).subscribe((data) => {
      this.blogForm = data;
    });
  }

  update() {
    this.blogservice.update(this.blogForm)
    .subscribe({
      next:(data) => {
        this.router.navigate(["/blogs/home"]);
      },
      error:(err) => {
        console.log(err);
      }
    })
  }

}
