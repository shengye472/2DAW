import { Routes } from '@angular/router';
import { InitialComponent } from './Component/initial/initial.component';
import { GamesComponent } from './Component/games/games.component';
import { ErrorComponent } from './Component/error/error.component';
import { GamesDetailComponent } from './Component/games-detail/games-detail.component';
import { guardsGuard } from './Guard/guards.guard';

export const routes: Routes = [
    {path: '', component: InitialComponent},
    {path: 'games',component: GamesComponent, canActivate: [guardsGuard]},
    {path: 'games/:gameCode', component: GamesDetailComponent},
    {path: '**', component: ErrorComponent}
];
