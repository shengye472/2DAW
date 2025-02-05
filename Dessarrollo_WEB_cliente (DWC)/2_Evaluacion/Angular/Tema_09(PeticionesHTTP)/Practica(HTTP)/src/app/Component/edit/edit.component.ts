import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpServiceService } from '../../Service/http-service.service';
import { Articulo } from '../../Model/articulo';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit',
  imports: [FormsModule],
  templateUrl: './edit.component.html',
  styleUrl: './edit.component.css'
})
export class EditComponent {

  articulo!: Articulo;

  constructor(private router: Router, private http: HttpServiceService, private url: ActivatedRoute) {}

  ngOnInit() {
    this.url.params.subscribe(
      params => {
        this.getArticulo(params['id']);
      }
    )
  }

  getArticulo(id: string){
    this.http.getById(id).subscribe({
      next: data => this.articulo = {...data},
      error: error => console.log('Error ' + error.status)
    })
  } 

  cancel() {
    this.router.navigate(['/articulos']);
  }

  update(){
    this.http.put(this.articulo).subscribe({
      next: data => {
        console.log('Articulo actualizado');
        this.router.navigate(['/articulos']);
      },
      error: error => console.log('Error ' + error.status)
    })
  }

}
