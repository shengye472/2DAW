import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game, GameDetail } from '../Model/game';

@Injectable({
  providedIn: 'root'
})
export class HttpGameService {

  private url = 'http://localhost:8080/api/games';

  constructor(private http: HttpClient) { }

  getGames(): Observable<Game[]> {
    return this.http.get<Game[]>(this.url);
  }

  getGame(gameCode: string): Observable<GameDetail>{
    return this.http.get<GameDetail>(this.url + '/' + gameCode);
  }
}
