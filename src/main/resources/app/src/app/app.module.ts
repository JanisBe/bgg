import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {GameListComponent} from './game-list/game-list.component';
import {GameDetailsComponent} from './game-details/game-details.component';
import {CreateGameComponent} from './create-game/create-game.component';
import {UpdateGameComponent} from './update-game/update-game.component';
import {AppRoutingModule} from "./app.routing.module";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    GameListComponent,
    GameDetailsComponent,
    CreateGameComponent,
    UpdateGameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
