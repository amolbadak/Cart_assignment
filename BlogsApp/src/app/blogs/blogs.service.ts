import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Blogs } from './blogs';

@Injectable({
  providedIn: 'root'
})
export class BlogsService {

  constructor(private http: HttpClient) { }


  get() {
    return this.http.get<Blogs[]>('http://localhost:3000/blogs');
  }
  create(payload: Blogs) {
    return this.http.post<Blogs>('http://localhost:3000/blogs', payload);
  }
 

  getbyid(id:number)
  {
    return this.http.get<Blogs>(`http://localhost:3000/blogs/${id}`);

  }

  update(payload:Blogs)
  {
    return this.http.put(`http://localhost:3000/blogs/${payload.id}`,payload);
  }

  delete(id:number){
    return this.http.delete<Blogs>(`http://localhost:3000/blogs/${id}`);
 }
}
