import { Component } from '@angular/core';
import { Articulo } from '../../Model/articulo';
import { Router } from '@angular/router';
import { HttpServiceService } from '../../Service/http-service.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-new',
  imports: [FormsModule],
  templateUrl: './new.component.html',
  styleUrl: './new.component.css'
})
export class NewComponent {

  articulo: Articulo = {
    id: '',
    nombre: '',
    descripcion: '',
    precio: 0,
    unidades: 0
  }

  constructor(private router: Router, private http: HttpServiceService) {}


  cancel() {
    this.router.navigate(['/articulos']);
  }

  save() {
    this.http.post(this.articulo).subscribe({
      next: data => {
        console.log('Articulo guardado');
        this.router.navigate(['/articulos']);
      },
      error: error => console.log('Error ' + error.status)
    })
  }
}
