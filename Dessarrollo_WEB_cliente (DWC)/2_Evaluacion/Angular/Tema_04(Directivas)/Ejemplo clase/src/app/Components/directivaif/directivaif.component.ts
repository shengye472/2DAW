import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Articulo } from '../../interfaces/articulo';
import { ARTICULOS } from '../../Datos/articulos';
@Component({
  selector: 'app-directivaif',
  imports: [CommonModule],
  templateUrl: './directivaif.component.html',
  styleUrl: './directivaif.component.css'
})
export class DirectivaifComponent {
  isLogged: boolean = true

  articulos: Articulo[] = ARTICULOS

  verDiv() {
    this.isLogged = true
  }

  ocultarDiv() {
    this.isLogged = false
  }
}
