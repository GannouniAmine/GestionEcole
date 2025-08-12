import { Injectable } from '@angular/core';
import { environment } from '../../environement/environement.developpement';
import { HttpClient } from '@angular/common/http';
import { Reglement } from '../model/reglement';
import { Observable } from 'rxjs';
import { Eleve } from '../model/eleve';
import { Listreglement } from '../model/listreglement';

@Injectable({
  providedIn: 'root'
})
export class ReglementService {
  baseUrl= environment.baseUrl + "reglements";

  constructor(private http: HttpClient) { }

  // GET /lister
  findAllReglements(): Observable<Listreglement[]> {
    return this.http.get<Listreglement[]>(`${this.baseUrl}/lister`);
  }

  // GET /findById/{id}
  findReglementById(id: number): Observable<Reglement> {
    return this.http.get<Reglement>(`${this.baseUrl}/findById/${id}`);
  }

  // POST /save
  createReglement(reglement: Reglement): Observable<Reglement> {
    return this.http.post<Reglement>(`${this.baseUrl}/save`, reglement);
  }

  // DELETE /delete/{id}
  deleteReglementById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${id}`);
  }

  // GET /findallEleveByniveau/{niveauScolaire}
  getAllEleveByNiveau(niveauScolaire: string): Observable<Eleve[]> {
    return this.http.get<Eleve[]>(`${this.baseUrl}/findallEleveByniveau/${niveauScolaire}`);
  }

  // GET /findallEleveByniveaupaye/{niveauScolaire}
  getAllEleveByNiveauPaye(niveauScolaire: string): Observable<Eleve[]> {
    return this.http.get<Eleve[]>(`${this.baseUrl}/findallEleveByniveaupaye/${niveauScolaire}`);
  }

  // DELETE /deleteEleve/{id}
  deleteEleveById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteEleve/${id}`);
  }

  // GET /findallEleveByniveaupayeAffecte/{niveauScolaire}
  getAllEleveByNiveauPayeAffecte(niveauScolaire: string): Observable<Eleve[]> {
    return this.http.get<Eleve[]>(`${this.baseUrl}/findallEleveByniveaupayeAffecte/${niveauScolaire}`);
  }

  // GET /findallreglementbyeleve/{ideleve}
  getAllReglementByEleve(idEleve: number): Observable<Listreglement[]> {
    return this.http.get<Listreglement[]>(`${this.baseUrl}/findallreglementbyeleve/${idEleve}`);
  }
}
