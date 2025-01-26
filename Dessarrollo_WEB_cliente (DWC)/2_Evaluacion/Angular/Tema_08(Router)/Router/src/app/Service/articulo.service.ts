import { Injectable } from '@angular/core';
import { Articulo, ARTICULOS } from '../Model/articulo';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

  constructor() { }

  articulos: Articulo[] = ARTICULOS;

  getArticulos(): Articulo[] {
    return this.articulos;
  }

  getArticulo(id: string): Articulo {
    let num = this.articulos.findIndex(articulo => articulo.id === id);
    return this.articulos[num];
  }

  putArticulo(articulo: Articulo) {
    let num = this.articulos.findIndex(art => art.id === articulo.id);
    if (num !== -1) {
      this.articulos[num] = articulo;
    } else {
      alert('El articulo no existe');
    }
  }

  postArticulo(articulo: Articulo) {
    let num = this.articulos.findIndex(art => art.id === articulo.id);
    if (num === -1) {
      this.articulos.push(articulo);
    } else {
      alert('El articulo ya existe');
    }
  }

  deleteArticulo(id: string) {
    let num = this.articulos.findIndex(articulo => articulo.id === id);
    if (num !== -1) {
      this.articulos.splice(num, 1);
    } else {
      alert('No existe el articulo');
    }
  }
}
