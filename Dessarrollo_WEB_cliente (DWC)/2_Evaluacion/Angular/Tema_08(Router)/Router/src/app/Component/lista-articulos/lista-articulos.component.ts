import { Component } from '@angular/core';
import { ArticuloService } from '../../Service/articulo.service';
import { Articulo } from '../../Model/articulo';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-lista-articulos',
  imports: [RouterLink],
  templateUrl: './lista-articulos.component.html',
  styleUrl: './lista-articulos.component.css'
})
export class ListaArticulosComponent {

  constructor( private SERVICE: ArticuloService) { }

  articulos!: Articulo[];

  ngOnInit() {
    this.articulos = this.SERVICE.getArticulos();
  }

}
