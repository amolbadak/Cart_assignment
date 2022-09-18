  import { Component, OnInit } from '@angular/core';

  @Component({
    selector: 'app-todo',
    templateUrl: './todo.component.html',
    styleUrls: ['./todo.component.css']
  })
  export class TodoComponent implements OnInit {
  title="Todo list ";
  list:any[]=[
    {
    "name":"Billpayment"
    },
    {
      "name":"Tea Making"
      },
      {
        "name":"Bookshoping"
        },
  ]


    constructor() { }

    ngOnInit(): void {
    }

  addtask(item:string)
  {
    this.list.push({id:this.list.length,name:item})
  console.log(this.list)
  }
  remove(id:number)
  {
    //this.list.splice(id, 1);
    //this.list=this.list.filter((item)=>item!==id);
    this.list = this.list.filter((item)=> !item.state);
    console.log(id)
  }



  public getLength(){
    return this.list.filter(item => !item.completed).length;
  }

  buttonState() {
    return !this.list.some(item => item.state);
  }

  }
