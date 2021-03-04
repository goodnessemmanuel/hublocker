import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import {Locker} from "./locker";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root'
})

export class LockerService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getAllLocationLockers() : Observable<Locker[]>{
    return this.http.get<Locker[]>(`${this.apiServerUrl}/api/v1/lockers`);
  }

  public getLockersByStateOrCity(cityOrState: string) : Observable<Locker[]>{
    return this.http.get<Locker[]>(`${ this.apiServerUrl }/api/v1/lockers/search?key=${ cityOrState }`);
  }

}
