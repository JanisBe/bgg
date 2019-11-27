import {Component, OnInit} from '@angular/core';
import {Game} from "../game";
import {ActivatedRoute, Router} from "@angular/router";
import {GameService} from "../game.service";

@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.css']
})
export class GameDetailsComponent implements OnInit {
  id: number;
  game: Game;

  constructor(private route: ActivatedRoute, private router: Router,
              private gameService: GameService) {
  }


  ngOnInit() {

    this.game = new Game();
    this.id = this.route.snapshot.params['id'];
    this.gameService.getGame(this.id)
      .subscribe(data => {
        console.log(data);
        this.game = data;
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['games']);
  }

}
