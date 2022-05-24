import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Weather} from './celsius-client/weather';
import { Converter } from './celsius-client/converter';

@Injectable({  providedIn: 'root' })
export class RestCallService {
  constructor(private http: HttpClient) {   }
  
  public putREST(celsius: number) : Observable <Converter> {
    let url = 'http://localhost:8080/RESTserver_temperature/resources/weather';
    let body = new Converter(celsius, 0);
    let headers = { 'Content-Type': 'application/json' };
    return this.http.put<Converter>(url, body, {headers});
  }
  
  public getREST(ort: string) : Observable <Weather[]>   {
    let url = 'http://localhost:8080/RESTserver_temperature/resources/weather';
    let searchParam = {location: ort};
    return this.http.get<Weather[]>(url, {params: searchParam});
  }
  
  
}
