import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tarea } from '../../Model/tarea';
import { HttpTareaService } from '../../Service/http-tarea.service';

@Component({
  selector: 'app-fin',
  imports: [],
  templateUrl: './fin.component.html',
  styleUrl: './fin.component.css'
})
export class FinComponent {

  constructor(private url: ActivatedRoute, private router: Router, private http: HttpTareaService) { }

  tarea!: Tarea;

  ngOnInit() {
    this.url.params.subscribe(
      params => {
        this.http.get(params['id']).subscribe({
          next: data => (this.tarea = data),
          error: error => console.error('There was an error')
        })
      }
    )
  }

  finish(){
    this.tarea.estado = 'Realizada';
    console.log(this.tarea);
    this.http.put(this.tarea).subscribe({
      next: data => this.router.navigate(['/tareas']),
      error: error => console.error('There was an error')
    })
  }

  back(){
    this.router.navigate(['/tareas']);
  }
}
