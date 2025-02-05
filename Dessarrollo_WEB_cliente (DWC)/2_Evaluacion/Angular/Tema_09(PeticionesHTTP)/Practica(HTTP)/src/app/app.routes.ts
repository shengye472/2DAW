import { Routes } from '@angular/router';
import { StartComponent } from './Component/start/start.component';
import { ErrorComponent } from './Component/error/error.component';
import { ListComponent } from './Component/list/list.component';
import { EditComponent } from './Component/edit/edit.component';
import { NewComponent } from './Component/new/new.component';

export const routes: Routes = [
    {path: '', component: StartComponent},
    {path: 'articulos', component: ListComponent},
    {path: 'articulos/edit/:id', component: EditComponent},
    {path: 'articulos/new', component: NewComponent},
    {path: '**', component: ErrorComponent}
];
