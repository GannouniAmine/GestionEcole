import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environement/environement.developpement';
import { ListEleve } from '../model/list-eleve';
import { Parent } from '../model/parent';
import { Listparent } from '../model/listparent';

@Injectable({
  providedIn: 'root'
})
export class ParentService {

  private apiUrl = environment.baseUrl + 'parent';

  constructor(private http: HttpClient) { }

  findAllParents(): Observable<Listparent[]> {
    return this.http.get<Listparent[]>(`${this.apiUrl}/lister`);
  }

  ajouterEleveAuParent(email: string): Observable<void> {
    return this.http.get<void>(`${this.apiUrl}/ajouterEleveparent/${email}`);
  }

  getParentByEleveId(id: number): Observable<Parent> {
    return this.http.get<Parent>(`${this.apiUrl}/${id}/parent`);
  }

  findAllEleveByParentId(): Observable<ListEleve[]> {
    return this.http.get<ListEleve[]>(`${this.apiUrl}/suivi`);
  }
}
