import { Inject, inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { Router } from '@angular/router';
import { HttpTareaService } from '../Service/http-tarea.service';

export const guardsGuard: CanActivateFn = (route, state) => {
  let password = prompt('Introduce la contraseña');
  if (inject(HttpTareaService).getPassword() === password) {
    return true;
  }
  inject(Router).navigate(['/tareas/panel/error']);
  return false;
};
