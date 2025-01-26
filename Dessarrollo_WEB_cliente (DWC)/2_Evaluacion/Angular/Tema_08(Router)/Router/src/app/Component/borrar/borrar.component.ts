import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ArticuloService } from '../../Service/articulo.service';
import { Articulo } from '../../Model/articulo';

@Component({
  selector: 'app-borrar',
  imports: [RouterLink],
  templateUrl: './borrar.component.html',
  styleUrl: './borrar.component.css'
})
export class BorrarComponent {

  constructor(private URLDATA: ActivatedRoute, private SERVICE: ArticuloService) { }

  articulo!: Articulo;


  ngOnInit() {
    this.URLDATA.params.subscribe(params => this.articulo = this.SERVICE.getArticulo(params['id']));
  }

  delete() {
    this.SERVICE.deleteArticulo(this.articulo.id);
  }
}
