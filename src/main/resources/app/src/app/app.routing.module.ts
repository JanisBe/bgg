import {NgModule} from "@angular/core";
import {RouterModule, Routes} from '@angular/router';
import {CreateGameComponent} from "./create-game/create-game.component";
import {UpdateGameComponent} from "./update-game/update-game.component";
import {GameListComponent} from "./game-list/game-list.component";

const routes: Routes = [

  {path: '', redirectTo: '/games', pathMatch: 'full'},
  {path: 'games', component: GameListComponent},
  {path: 'add', component: CreateGameComponent},
  {path: 'update/:id', component: UpdateGameComponent},
  {path: 'details/:id', component: UpdateGameComponent},

];

@NgModule({

  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule {
}
