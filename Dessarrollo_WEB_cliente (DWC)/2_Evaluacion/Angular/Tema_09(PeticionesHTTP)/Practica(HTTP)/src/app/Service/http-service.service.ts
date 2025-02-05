import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Articulo } from '../Model/articulo';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  url = "http://localhost:3000/articulos";

  constructor(private http: HttpClient) { }

  getAll():Observable<Articulo[]> {
    return this.http.get<Articulo[]>(this.url);
  }

  getById(id: string):Observable<Articulo> {
    return this.http.get<Articulo>(this.url + "/" + id);
  }

  delete(id: string):Observable<Articulo> {
    return this.http.delete<Articulo>(this.url + "/" + id);
  }

  put(articulo: Articulo):Observable<Articulo> {
    return this.http.put<Articulo>(this.url + "/" + articulo.id, articulo);
  }

  post(articulo: Articulo):Observable<Articulo> {
    return this.http.post<Articulo>(this.url, articulo);
  }
}
