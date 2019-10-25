import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {GameListComponent} from './game-list/game-list.component';
import {GameDetailsComponent} from './game-details/game-details.component';

@NgModule({
  declarations: [
    AppComponent,
    GameListComponent,
    GameDetailsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
