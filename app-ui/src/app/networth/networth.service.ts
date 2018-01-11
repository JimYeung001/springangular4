import { Injectable } from '@angular/core';
import { NetWorth } from './networth-model/net-worth';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';


@Injectable()
export class NetworthService {

  private apiUrl = "http://localhost:8888/webapi/networths";

  constructor(private http: Http) { }

  findAll(): Observable<NetWorth[]> {
    return this.http.get(this.apiUrl, { headers: this.getHeaders() })
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || 'Server Error'));
  }

  findOneById(id: number): Observable<NetWorth> {
    return this.http.get(this.apiUrl + '/' + id, { headers: this.getHeaders() })
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json() || 'Server Error'));
  }

  updateNetworth(networth: NetWorth){
    return this.http.put(this.apiUrl + '/' + networth.id, networth, { headers: this.getHeaders() })
    .map((res: Response) => res.json())
    .catch((error: any) => Observable.throw(error.json() || 'Server Error'));
  }


  getHeaders() {
    let userName: string = 'admin';
    let password: string = 'password';
    let headers: Headers = new Headers();
    headers.append("Authorization", "Basic " + btoa(userName + ":" + password));
    headers.append("Content-Type", "application/json");
    return headers;
  }

}
