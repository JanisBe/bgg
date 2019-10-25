import {Component, OnInit} from '@angular/core';
import {GameService} from "../game.service";
import {Game} from "../game";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styleUrls: ['./create-game.component.css']
})
export class CreateGameComponent implements OnInit {
  game: Game = new Game();
  submitted: boolean = false;

  constructor(private gameService: GameService, private router: Router) {
  }

  ngOnInit() {
  }

  newGame(): void {
    this.submitted = false;
    this.game = new Game();
  }

  save() {
    this.gameService.createGame(this.game)
      .subscribe(data => console.log(data), error => console.log(error));
    this.game = new Game();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/games']);
  }

}
