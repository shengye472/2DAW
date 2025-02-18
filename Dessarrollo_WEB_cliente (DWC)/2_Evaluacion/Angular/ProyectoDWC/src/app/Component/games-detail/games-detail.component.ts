import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpGameService } from '../../Service/http-game.service';
import { GameDetail } from '../../Model/game';
import { FormsModule } from '@angular/forms';
import { CharacterComponent } from '../character/character.component';

@Component({
  selector: 'app-games-detail',
  imports: [FormsModule, CharacterComponent],
  templateUrl: './games-detail.component.html',
  styleUrl: './games-detail.component.css'
})
export class GamesDetailComponent {

  constructor(private router: Router, private http: HttpGameService, private url: ActivatedRoute) { }

  game!: GameDetail;


  ngOnInit() {
    this.url.params.subscribe(
      params => {
        this.http.getGame(params['gameCode']).subscribe({
          next: data => (this.game = data),
          error: error => console.log('Error' + error)
        });
      });
    console.log(this.game)
  }

  goBack() {
    this.router.navigate(["/games"]);
  }

}
