import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ArticulosComponent } from "./Components/articulos/articulos.component";
import { DirectivaifComponent } from './Components/directivaif/directivaif.component';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ArticulosComponent, DirectivaifComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

}
