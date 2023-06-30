import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PlayerRegistrationReq } from 'src/app/models/player-registration-req';
import { environment } from 'src/environments/environments';

@Injectable({
  providedIn: 'root',
})
export class PlayerService {
  private readonly playerUrl = `${environment.api.baseUrl}/${environment.api.playerUrl}`;

  constructor(private http: HttpClient) {}

  registerPlayer(player: PlayerRegistrationReq): Observable<void> {
    return this.http.post<void>(this.playerUrl, player);
  }
}
