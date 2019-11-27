import {Component, OnInit} from '@angular/core';
import {GameService} from '../game.service';
import {Router} from '@angular/router';
import {Game} from "../game";

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {
  sortedData: Game[];
  private games: any;

  constructor(private gameService: GameService, private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.games = this.gameService.getGameList();
    // this.sortedData = this.games.slice();
  }

  deleteGame(id: number) {
    this.gameService.deleteGame(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  gameDetails(id: number) {
    this.router.navigate(['details', id]);
  }
}
