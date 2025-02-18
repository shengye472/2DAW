import { Component, Input } from '@angular/core';
import { Character } from '../../Model/character';

@Component({
  selector: 'app-character',
  imports: [],
  templateUrl: './character.component.html',
  styleUrl: './character.component.css'
})
export class CharacterComponent {

  @Input() character!: Character;

}
