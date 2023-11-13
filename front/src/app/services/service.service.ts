import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private baseUrl = 'http://192.168.33.10:8089/SpringMVC/piste';

  constructor(private http: HttpClient) { }

  addPiste(piste: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, piste);
  }

  getAllPistes(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }
}
