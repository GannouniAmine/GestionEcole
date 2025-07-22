import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cours } from '../model/cours';
import { environment } from '../../environement/environement.developpement';
import { ListCour } from '../model/list-cour';
import { Professeur } from '../model/professeur';


@Injectable({
  providedIn: 'root'
})
export class CoursService {
  apiUrl = environment.baseUrl+ "cours"
  

  constructor(private http: HttpClient) { }


  findAllCoursDto(): Observable<Cours[]> {
    return this.http.get<Cours[]>(`${this.apiUrl}/all`);
  }


  findCoursDtoById(id: number): Observable<Cours> {
    return this.http.get<Cours>(`${this.apiUrl}/getById/${id}`);
  }


  createCoursDto(CoursDto: Cours): Observable<Cours> {
    return this.http.post<Cours>(`${this.apiUrl}/create`, CoursDto);
  }


  deleteCoursDto(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }


  // Méthode pour uploader un fichier de cours
  uploadCoursDtoFile(id: number, image: File): Observable<Cours> {
    const formData: FormData = new FormData();
    formData.append('image', image);
    return this.http.post<Cours>(`${this.apiUrl}/uploadFile/${id}`, formData);
  }
 
  findAllCoursByclasseAndmatiere(idclasse:number,idmatiere:number): Observable<ListCour[]> {
    return this.http.get<ListCour[]>(`${this.apiUrl}/listallcoursbyclassandmatiere/${idclasse}/${idmatiere}`);
  }

  findAllprof(): Observable<Professeur[]> {
    return this.http.get<Professeur[]>(`${this.apiUrl}/listerprof`);
  }

}



