import { Component } from '@angular/core';
import { ObservablesService } from '../../Service/observables.service';

@Component({
  selector: 'app-componente2',
  imports: [],
  templateUrl: './componente2.component.html',
  styleUrl: './componente2.component.css'
})
export class Componente2Component {
  constructor(private ServiceObserver: ObservablesService) { }
  count!: number;
  observable: any;

  ngOnInit() {
    this.observable = this.ServiceObserver.contador.subscribe({
      next: data => this.count = data,
      error: error => console.error(error),
      complete: () => console.log('Completado')
    });
  }

  pluscount() {
    this.ServiceObserver.pluscount();
  }

  cancel() {
    console.log('Cancelando subscripción Componente 1');
    this.observable.unsubscribe();
  }

  complete() {
    console.log('Completando observador');
    this.ServiceObserver.completeObserver();
  }
}
