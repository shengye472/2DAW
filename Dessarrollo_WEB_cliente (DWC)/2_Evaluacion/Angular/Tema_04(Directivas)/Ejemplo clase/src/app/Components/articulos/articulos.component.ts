import { Component } from '@angular/core';
import { Articulo } from '../../interfaces/articulo';
import { ARTICULOS } from '../../Datos/articulos';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-articulos',
  imports: [FormsModule],
  templateUrl: './articulos.component.html',
  styleUrl: './articulos.component.css'
})
export class ArticulosComponent {

  articulos: Articulo[] = ARTICULOS
  articulo: Articulo = this.articulos[0]
  id: string = this.articulo.id

  categorias: string[] = ["Todas"]
  filtro: string = "Todas"
  visible: boolean = false

  ngOnInit() {
    console.log(this.articulos)

    this.articulos.forEach(a => {
      if (!this.categorias.includes(a.categoria))
        this.categorias.push(a.categoria)
    })
  }

  comprar(articulo: Articulo) {
    alert(`Lo has comprado ` + articulo.nombre)
    console.log(articulo)
  }

  ver() {
    let miArticulo = this.articulos.find(a => a.id == this.id)
    if (miArticulo)
      this.articulo = miArticulo
    else
      alert("Error. No exisate el articulo " + this.id)
  }

  mostrar(articulo: Articulo) {
    this.visible = true
    this.articulo = articulo
  }

  suma() {
    this.articulo.unidades++
  }
  resta() {
    this.articulo.unidades--
  }

  filtrar(filtro: string) {
    this.articulos = ARTICULOS.filter(a => a.categoria == filtro || filtro == "Todas")
    this.visible = false
  }
}
