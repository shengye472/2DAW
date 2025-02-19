import { Routes } from '@angular/router';
import { InicioComponent } from './Component/inicio/inicio.component';
import { TareasComponent } from './Component/tareas/tareas.component';
import { FinComponent } from './Component/fin/fin.component';
import { PanelComponent } from './Component/panel/panel.component';
import { ErrorComponent } from './Component/error/error.component';
import { guardsGuard } from './Guard/guards.guard';

export const routes: Routes = [
    {path: '', component: InicioComponent},
    {path: 'tareas', component: TareasComponent},
    {path: 'tareas/fin/:id', component: FinComponent},
    {path: 'tareas/panel', component: PanelComponent, canActivate: [guardsGuard]},
    {path: 'tareas/panel/error', component: ErrorComponent},
    {path: '**', component: InicioComponent}
];
