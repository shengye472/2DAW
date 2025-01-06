import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Articulo, ARTICULOS } from '../../Modelos/articulo';

@Component({
  selector: 'app-articulos',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './articulos.component.html',
  styleUrl: './articulos.component.css'
})
export class ArticulosComponent {

  articulos:Array<Articulo> = ARTICULOS;
  articulo:Articulo = this.articulos[3];
  
  comprar(articulo:Articulo){
    console.log(articulo);
  }
  
  id:string="";

  ver(){
    let art = this.articulos.find(a => a.id == this.id);
    if(art){
      this.articulo = art
    }else{
      alert("El articulo no existe!!!");
    }
  }

  aumentar(unidad:number){
    this.articulo.unidades++;
  }
  disminuir(unidad:number){
    if (unidad == 0) {
      alert("No se puede disminuir más unidades!!!");
    }else{
      this.articulo.unidades--;
    }
  }
}
