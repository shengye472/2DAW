import { Component, NgModule } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ArticuloService } from '../../Service/articulo.service';
import { Articulo } from '../../Model/articulo';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-nuevo',
  imports: [RouterLink, FormsModule],
  templateUrl: './nuevo.component.html',
  styleUrl: './nuevo.component.css'
})
export class NuevoComponent {

  constructor(private SERVICE: ArticuloService) { }

  articulo!: Articulo;

  ngOnInit() {
    this.articulo = {
      id: '',
      nombre: '',
      descripcion: '',
      precio: 0,
      unidades: 0
    };
  }

  save() {
    console.log(this.articulo);
    this.SERVICE.postArticulo(this.articulo);
  }
}