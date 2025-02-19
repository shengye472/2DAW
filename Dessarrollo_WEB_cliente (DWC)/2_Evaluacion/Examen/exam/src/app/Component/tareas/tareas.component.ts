import { Component } from '@angular/core';
import { HttpTareaService } from '../../Service/http-tarea.service';
import { Tarea } from '../../Model/tarea';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tareas',
  imports: [FormsModule],
  templateUrl: './tareas.component.html',
  styleUrl: './tareas.component.css'
})
export class TareasComponent {
  constructor(private http: HttpTareaService, private router:Router) { }

  filtrar!: Tarea[] ;
  tareas: Tarea[] = [...this.filtrar];

  selected = "Todas";

  pendiente: number = 0;
  realizado: number = 0;

  ngOnInit() {
    this.getAll();

  }

  filtrarTareas(event: any) {
    if (event.target.value === this.selected) {
      this.getAll();
    } else {
      this.tareas = this.filtrar.filter(tarea => tarea.estado === event.target.value);
    }
    this.count();
  }

  getAll() {
    this.http.getAll().subscribe({
      next: data => (this.filtrar = [...data], this.count()),
      error: error => console.error('There was an error!', error)
    })
  }

  count() {
    this.pendiente = this.tareas.filter(tarea => tarea.estado == "Pendiente").length;
    this.realizado = this.tareas.filter(tarea => tarea.estado == "Realizada").length;
  }

  fin(id: string){
    this.router.navigate(['/tareas/fin/'+ id]);
  }
}

