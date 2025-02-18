import { Character } from "./character";
import { Director } from "./director";

export interface Game {
    id: number;
    gameCode: string;
    title: string;
}

export interface GameDetail {
    id: number;
    gameCode: string;
    title: string;
    releaseYear: string;
    description: string;
    director: Director;
    characterGames: Character[];
}