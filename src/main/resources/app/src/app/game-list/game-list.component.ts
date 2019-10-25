import {Component, OnInit} from '@angular/core';
import {GameService} from '../game.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {
  private games: any;

  constructor(private gameService: GameService, private router: Router) {
  }


  ngOnInit() {
    this.reloadData();
  }

  private reloadData() {
    this.games = this.gameService.getGameList();
  }
}
