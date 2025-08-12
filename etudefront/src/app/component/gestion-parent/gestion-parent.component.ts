import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ParentService } from '../../service/parent.service';
import { ListEleve } from '../../model/list-eleve';

@Component({
  selector: 'app-gestion-parent',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './gestion-parent.component.html',
  styleUrl: './gestion-parent.component.css'
})
export class GestionParentComponent implements OnInit {

  email: string = '';
  listeleve : ListEleve[] = [];
  constructor(
    private parentService: ParentService
  ) { }

  ngOnInit(): void {
    this.getAllEleveByParentId();
    
  }

affecterEleveauParent() {
  if (this.email) {
    this.parentService.ajouterEleveAuParent(this.email).subscribe({
      next: () => {
        alert('L\'élève a été ajouté au parent avec succès.');
        this.email = '';
        this.getAllEleveByParentId();
      },
      error: (err) => {
        console.error('Erreur lors de l\'ajout de l\'élève au parent:', err);
        alert('Une erreur est survenue lors de l\'ajout de l\'élève au parent.');
      }
    });
}}

getAllEleveByParentId() {
  this.parentService.findAllEleveByParentId().subscribe({
    next: (data) => {
      this.listeleve = data;
    },
    error: (err) => {
      console.log('Erreur lors de la récupération des élèves');
      alert('Une erreur est survenue lors de la récupération des élèves.');
    }
  });}
  


}
