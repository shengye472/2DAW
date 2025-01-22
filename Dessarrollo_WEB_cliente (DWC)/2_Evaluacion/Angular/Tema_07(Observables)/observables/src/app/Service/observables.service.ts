import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ObservablesService {

  constructor() { }

  contador:BehaviorSubject<number> = new BehaviorSubject(0);

  pluscount(){
    console.log('Aumentando contador');
    this.contador.next(this.contador.value + 1);
  }

  completeObserver(){
    console.log('Completado');
    this.contador.complete();
  }
}
