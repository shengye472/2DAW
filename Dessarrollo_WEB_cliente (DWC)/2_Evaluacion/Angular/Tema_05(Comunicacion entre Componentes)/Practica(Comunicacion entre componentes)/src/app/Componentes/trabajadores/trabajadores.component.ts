import { Component } from '@angular/core';
import { TrabajadorComponent } from '../trabajador/trabajador.component';
import { Trabajador, TRABAJADORES } from '../../Modelos/trabajador';

@Component({
  selector: 'app-trabajadores',
  imports: [TrabajadorComponent],
  templateUrl: './trabajadores.component.html',
  styleUrl: './trabajadores.component.css'
})
export class TrabajadoresComponent {
  trabajadores:Array<Trabajador> = TRABAJADORES;
  number!: number;

  findTrabajador(id: number) {
   return this.trabajadores.findIndex((t) => t.id === id);
  }
  plus(id: number) {
    this.number = this.findTrabajador(id);
    this.trabajadores[this.number].votos++;
    console.log(this.trabajadores);
  }

  minus(id: number) {
    this.number = this.findTrabajador(id);
    if (this.trabajadores[this.number].votos >= 1) {
      this.trabajadores[this.number].votos--;
    }else {
      alert('No se puede numeros negativos');
    }
    console.log(this.trabajadores);
  }

  delete(id: number){
    this.number = this.findTrabajador(id);
    this.trabajadores.splice(this.number, 1);
    console.log(this.trabajadores);
  }
}
