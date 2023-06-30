import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthReq } from 'src/app/models/auth-req';
import { AuthRes } from 'src/app/models/auth-res';
import { environment } from 'src/environments/environments';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private readonly authUrl = `${environment.api.baseUrl}/${environment.api.authUrl}`;

  constructor(private http: HttpClient) {}

  login(authRequest: AuthReq): Observable<AuthRes> {
    return this.http.post<AuthRes>(this.authUrl, authRequest);
  }
}
