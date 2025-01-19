import { Component } from '@angular/core';
import { ArticulosService } from '../../Services/articulos.service';
import { Articulo } from '../../Modelos/articulo';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-articulos',
  imports: [FormsModule],
  templateUrl: './articulos.component.html',
  styleUrl: './articulos.component.css'
})
export class ArticulosComponent {
  constructor(private service: ArticulosService) { }

  articulos!: Articulo[];
  articulo!: Articulo;
  seeItem!: boolean;
  seeNew!: boolean;
  new!: Articulo;


  ngOnInit() {
    this.articulos = this.service.getArticulos();
  }

  ver(id: string) {
    this.seeItem = true;
    this.articulo = this.service.getArticulo(id);
  }

  cancel() {
    this.seeNew = false;
    this.seeItem = false;
  }

  newItem() {
    this.seeItem = false;
    this.seeNew = true;
    this.new = {
      id: '',
      nombre: '',
      descripcion: '',
      unidades: 0,
      precio: 0
    };
  }

  save() {
    if (this.new.id === '' || this.new.nombre === '' || this.new.descripcion === '') {
      alert('Faltan datos');
    } else {
      this.service.postArticulo(this.new);
      this.seeNew = false;
    }
  }

  update() {
    this.service.putArticulo(this.articulo);
  }

  remove(id: string) {
    this.service.deleteArticulo(id);
    this.seeItem = false;
  }
}
