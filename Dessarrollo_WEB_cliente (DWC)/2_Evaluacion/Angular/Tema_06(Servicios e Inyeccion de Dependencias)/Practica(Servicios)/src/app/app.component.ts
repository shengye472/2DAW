import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ArticulosComponent } from "./Componets/articulos/articulos.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ArticulosComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Practica';
}
