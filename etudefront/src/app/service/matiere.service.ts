import { Injectable } from '@angular/core';
import { Matiere } from '../model/matiere';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environement/environement.developpement';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {
  
  baseUrl = environment.baseUrl+ "matiere"
  constructor(private _httpClient :HttpClient) { }

  getAllMatiere(): Observable<Matiere[]> {
    return this._httpClient.get<Matiere[]>(`${this.baseUrl}/lister`);
  }

  getMatiereById(id :number): Observable<Matiere>{
    return this._httpClient.get<Matiere>(`${this.baseUrl}/getById/${id}`);
  }
  createMatiere(m : Matiere): Observable<Matiere>{
    return this._httpClient.post<Matiere>(`${this.baseUrl}/save`,m);
  }
  deleteMatiereById(id:number): Observable<void>{
    return this._httpClient.delete<void>(`${this.baseUrl}/delete/${id}`);
  }

  updateMatiere(matiere : Matiere): Observable<Matiere>{
    return this._httpClient.post<Matiere>(`${this.baseUrl}/update`,matiere);
  }

  getMatiereByName(nom:String): Observable<Matiere[]> {
    return this._httpClient.get<Matiere[]>(`${this.baseUrl}/getByName/${nom}`);
  }

}
