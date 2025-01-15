import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Trabajador } from '../../Modelos/trabajador';

@Component({
  selector: 'app-trabajador',
  imports: [],
  templateUrl: './trabajador.component.html',
  styleUrl: './trabajador.component.css'
})
export class TrabajadorComponent {

  @Input() trabajador!: Trabajador;
  @Output() plus = new EventEmitter<number>;
  @Output() minus = new EventEmitter<number>;
  @Output() delete = new EventEmitter<number>;


  voto(operation: boolean) {
    if (operation) {
      this.plus.emit(this.trabajador.id);
    }else {
      this.minus.emit(this.trabajador.id);
    }
  }

  borrar(){
    this.delete.emit(this.trabajador.id);
  }
}

