import { Routes } from '@angular/router';
import { ListaArticulosComponent } from './Component/lista-articulos/lista-articulos.component';
import { InicioComponent } from './Component/inicio/inicio.component';
import { ErrorComponent } from './Component/error/error.component';
import { BorrarComponent } from './Component/borrar/borrar.component';
import { VerComponent } from './Component/ver/ver.component';
import { NuevoComponent } from './Component/nuevo/nuevo.component';

export const routes: Routes = [
    {path: '', component: InicioComponent},
    {path: 'articulos', component: ListaArticulosComponent},
    {path: 'articulos/delete/:id', component: BorrarComponent},
    {path: 'articulos/new', component: NuevoComponent},
    {path: 'articulos/:id', component: VerComponent},
    {path: '**', component: ErrorComponent}
];
