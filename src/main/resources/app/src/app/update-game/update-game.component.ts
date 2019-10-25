import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {GameService} from "../game.service";
import {Game} from "../game";

@Component({
  selector: 'app-update-game',
  templateUrl: './update-game.component.html',
  styleUrls: ['./update-game.component.css']
})
export class UpdateGameComponent implements OnInit {
  id: number;
  game: Game;

  constructor(private route: ActivatedRoute, private router: Router, private ganeService: GameService) {
  }

  ngOnInit() {
    this.game = new Game();

    this.id = this.route.snapshot.params['id'];

    this.ganeService.getGame(this.id)
      .subscribe(data => {
        console.log(data);
        this.game = data;
      }, error => console.log(error));
  }

  updateGame() {
    this.ganeService.updateGame(this.id, this.game)
      .subscribe(data => console.log(data), error => console.log(error));
    this.game = new Game();
    this.gotoList();
  }

  onSubmit() {
    this.updateGame();
  }

  gotoList() {
    this.router.navigate(['/games']);
  }

}
