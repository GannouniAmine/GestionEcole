import { Injectable } from '@angular/core';
import { environment } from '../../environement/environement.developpement';
import { HttpClient } from '@angular/common/http';
import { ListEleve } from '../model/list-eleve';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EleveService {
  baseUrl=environment.baseUrl + "Eleve";
  constructor(private http: HttpClient) { }

  // GET /lister
  findAllElevesByParentId(): Observable<ListEleve[]> {
    return this.http.get<ListEleve[]>(`${this.baseUrl}/listalleleveByParentId`);
  }

  findAllEleve(): Observable<ListEleve[]> {
    return this.http.get<ListEleve[]>(`${this.baseUrl}/listalleleve`);
  }
}
