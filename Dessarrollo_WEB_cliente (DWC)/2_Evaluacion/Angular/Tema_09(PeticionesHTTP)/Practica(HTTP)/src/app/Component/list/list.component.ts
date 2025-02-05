import { Component } from '@angular/core';
import { Articulo } from '../../Model/articulo';
import { HttpServiceService } from '../../Service/http-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  imports: [],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent {

  ARTICULOS! : Articulo[];

  constructor(private http: HttpServiceService, private router: Router) {}

  ngOnInit() {
    this.http.getAll().subscribe({
      next: data => (this.ARTICULOS = data),
      error: error => console.log('Error ' + error.status)
      }
    );
  }

  volver() {
    this.router.navigate(['/']);
  }

  edit(id: string) {
    this.router.navigate(['articulos/edit/'+id]);
  }

  new(){
    this.router.navigate(['articulos/new']);
  }

  delete(id: string) {
    this.http.delete(id).subscribe({
      next: data => {
        console.log('Articulo eliminado');
        this.ngOnInit();
      },
      error: error => console.log('Error ' + error.status)
    })
  }

}
