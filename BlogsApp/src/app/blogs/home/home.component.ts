import { Component, OnInit } from '@angular/core';
import { OrderPipe } from 'ngx-order-pipe';
import { Blogs } from '../blogs';
import { BlogsService } from '../blogs.service';
import { ChangeDetectorRef } from '@angular/core';




declare var window: any;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  datetoday:number=Date.now()
  //date:Date | undefined;
allBlogs:Blogs[]=[];
id: number = 0;
idTodelete: number = 0;
deleteModal: any;
  dateNow: Date | undefined;
  constructor(private blogservice:BlogsService, private orderPipe:OrderPipe,private cdRef:ChangeDetectorRef) {
    console.log(this.orderPipe.transform(this.allBlogs, this.id));
   
   }

  ngOnInit(): void {
    this.deleteModal = new window.bootstrap.Modal(
      document.getElementById('deleteModal')
    );
 
    this.get();
    
    
  }


  ngAfterViewChecked()
  {
    //console.log( "! changement de la date du composant !" );
    this.dateNow = new Date();
    this.cdRef.detectChanges();
    console.log(this.dateNow)
  }

  get()
  {
    this.blogservice.get().subscribe((data) => {
      this.allBlogs = data;
    });
  }

  openDeleteModal(id: number) {
    this.idTodelete = id;
    this.deleteModal.show();
  }

  delete() {
    this.blogservice.delete(this.idTodelete).subscribe({
      next: (data) => {
        this.allBlogs = this.allBlogs.filter(_ => _.id != this.idTodelete)
        this.deleteModal.hide();
      },
    });
  }

}


