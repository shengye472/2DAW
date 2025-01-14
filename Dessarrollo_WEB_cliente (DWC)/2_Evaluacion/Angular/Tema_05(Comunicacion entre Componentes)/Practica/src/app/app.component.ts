import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TrabajadoresComponent } from './Componentes/trabajadores/trabajadores.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TrabajadoresComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Practica';
}
