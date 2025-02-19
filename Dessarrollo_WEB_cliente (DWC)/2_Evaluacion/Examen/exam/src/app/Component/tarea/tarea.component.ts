import { Component, Input } from '@angular/core';
import { Tarea } from '../../Model/tarea';

@Component({
  selector: 'app-tarea',
  imports: [],
  templateUrl: './tarea.component.html',
  styleUrl: './tarea.component.css'
})
export class TareaComponent {

  @Input() tarea!: Tarea;

}
