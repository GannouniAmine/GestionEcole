import { Component, OnInit } from '@angular/core';
import { ReglementService } from '../../service/reglement.service';
import { FormsModule } from '@angular/forms';
import { Listreglement } from '../../model/listreglement';
import { Reglement } from '../../model/reglement';
import { Eleve } from '../../model/eleve';
import { EleveService } from '../../service/eleve.service';
import { ListEleve } from '../../model/list-eleve';
import { ParentService } from '../../service/parent.service';
import { Listparent } from '../../model/listparent';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-gestion-reglement',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './gestion-reglement.component.html',
  styleUrl: './gestion-reglement.component.css'
})
export class GestionReglementComponent implements OnInit {

  reglements:Listreglement [] = [];
  reglement: Reglement = new Reglement();
  eleveList: ListEleve[] = [];
  parentList: Listparent[] = [];

  constructor(
    private reglementService : ReglementService,
    private eleveService: EleveService,
    private parentService: ParentService,

  ) { }

  ngOnInit(): void {
    this.getAllReglements();
    this.getAllEleves();
    this.getAllParents();
  }

  getAllReglements() {
    this.reglementService.findAllReglements().subscribe(
      (data) => {
        console.log('Reglements:', data);
        this.reglements = data;
      },
      (error) => {
        console.error('Error fetching reglements:', error);
      }
    );
  }
  createReglement(){
    this.reglementService.createReglement(this.reglement).subscribe(
      (data) => {
        console.log('Reglement created:', data);
        this.getAllReglements(); // Refresh the list after creation
        this.reglement = new Reglement(); // Reset the form
      },
      (error) => {
        console.error('Error creating reglement:', error);
      }
    );



  }
  deleteReglement(id: number) {
    this.reglementService.deleteReglementById(id).subscribe(
      () => {
        console.log('Reglement deleted:', id);
        this.getAllReglements(); // Refresh the list after deletion
      },
      (error) => {
        console.error('Error deleting reglement:', error);
      }
    );
  }

 getAllParents() {
    this.parentService.findAllParents().subscribe(
      (data) => {
        console.log('Parents:', data);
        this.parentList = data;
      },
      (error) => {
        console.error('Error fetching parents:', error);
      }
    );
  }
  getAllEleves() {
    this.eleveService.findAllEleve().subscribe(
      (data) => {
        console.log('Eleves:', data);
        this.eleveList = data;
      },
      (error) => {
        console.error('Error fetching eleves:', error);
      }
    );
  }




}
