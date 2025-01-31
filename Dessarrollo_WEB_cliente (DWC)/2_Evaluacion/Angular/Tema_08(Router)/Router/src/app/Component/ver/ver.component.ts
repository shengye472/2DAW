import { Component } from '@angular/core';
import { ArticuloService } from '../../Service/articulo.service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Articulo } from '../../Model/articulo';

@Component({
  selector: 'app-ver',
  templateUrl: './ver.component.html',
  imports: [RouterLink],
  styleUrl: './ver.component.css'
})
export class VerComponent {

  constructor(private SERVICE: ArticuloService, private URLDATA: ActivatedRoute) { }

  articulo!: Articulo;

  ngOnInit() {
    this.URLDATA.params.subscribe(params => {
      let temp = this.SERVICE.getArticulo(params['id']);
      this.articulo = {...temp};
    });
    // let temp = this.URLDATA.snapshot.params['id'];
    // let temp2 = this.URLDATA.snapshot.paramMap.get('id');
  }

}
