import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GameRes } from 'src/app/models/game-res';
import { environment } from 'src/environments/environments';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  private readonly gameUrl = `${environment.api.baseUrl}/${environment.api.gameUrl}`;

  constructor(private http: HttpClient) {}

  findChapter(
    name: string | undefined,
    num: string | undefined,
    part: string | undefined
  ): Observable<GameRes> {
    return this.http.get<GameRes>(
      `${this.gameUrl}?name=${name}&num=${num}&part=${part}`
    );
  }
}
