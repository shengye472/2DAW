import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Articulo } from '../Model/articulo';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  url = "http://localhost:3000/articulos";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Articulo[]> {
    return this.http.get<Articulo[]>(this.url).pipe(catchError(this.handleError));
  }

  getById(id: string): Observable<Articulo> {
    return this.http.get<Articulo>(this.url + "/" + id).pipe(catchError(this.handleError));
  }

  delete(id: string): Observable<Articulo> {
    return this.http.delete<Articulo>(this.url + "/" + id).pipe(catchError(this.handleError));
  }

  put(articulo: Articulo): Observable<Articulo> {
    return this.http.put<Articulo>(this.url + "/" + articulo.id, articulo).pipe(catchError(this.handleError));
  }

  post(articulo: Articulo): Observable<Articulo> {
    return this.http.post<Articulo>(this.url, articulo).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      switch (error.status) {
        case 400:
          errorMessage = 'Solicitud incorrecta (Bad Request)';
          break;
        case 401:
          errorMessage = 'No autorizado (Unauthorized)';
          break;
        case 403:
          errorMessage = 'Prohibido (Forbidden)';
          break;
        case 404:
          errorMessage = 'No encontrado (Not Found)';
          break;
        case 500:
          errorMessage = 'Error interno del servidor (Internal Server Error)';
          break;
        case 502:
          errorMessage = 'Bad Gateway';
          break;
        // Podemos agregar más casos para otros códigos de error
        default:
          errorMessage = `Error del servidor: ${error.status}`;
      }
    }
    return throwError(() => new Error(errorMessage));
  }
}
