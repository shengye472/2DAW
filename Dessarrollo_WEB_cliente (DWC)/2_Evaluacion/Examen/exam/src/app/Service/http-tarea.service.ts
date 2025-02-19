import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarea } from '../Model/tarea';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpTareaService {

  url = 'http://localhost:3000/tareas';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Tarea[]>{ 
    return this.http.get<Tarea[]>(this.url);
  }

  get(id: string): Observable<Tarea>{
    return this.http.get<Tarea>(`${this.url}/${id}`);
  }

  put(tarea: Tarea): Observable<Tarea>{
    return this.http.put<Tarea>(this.url + '/' + tarea.id, tarea);
  }

  password = '123';

  getPassword(): string{
    return this.password;
  }
}
