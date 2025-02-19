import { Component } from '@angular/core';
import { HttpTareaService } from '../../Service/http-tarea.service';
import { Tarea } from '../../Model/tarea';
import { Router } from '@angular/router';
import { TareaComponent } from "../tarea/tarea.component";

@Component({
  selector: 'app-panel',
  imports: [TareaComponent],
  templateUrl: './panel.component.html',
  styleUrl: './panel.component.css'
})
export class PanelComponent {

  tareas!: Tarea[];

  constructor(private http: HttpTareaService, private router: Router) { }

  ngOnInit() {
    this.http.getAll().subscribe({
      next: data => (this.tareas = data),
      error: error => console.error('There was an error!', error)
    })
  }

  back() {
    this.router.navigate(['/tareas']);
  }

}
