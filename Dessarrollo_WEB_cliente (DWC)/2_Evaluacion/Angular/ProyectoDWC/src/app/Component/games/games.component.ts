import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpGameService } from '../../Service/http-game.service';
import { Game } from '../../Model/game';

@Component({
  selector: 'app-games',
  imports: [],
  templateUrl: './games.component.html',
  styleUrl: './games.component.css'
})
export class GamesComponent {

  constructor(private http: HttpGameService, private router: Router){}

  GAMES!: Game[] | null;

  ngOnInit(){
    this.http.getGames().subscribe({
      next: data => (this.GAMES = data),
      error: error => console.log('Error' + error)
    })
  }

  moreDetail(gameCode: string){
    this.router.navigate(['/games/' + gameCode]);
  }

  goBack(){
    this.router.navigate(["/"]);
  }
}
