import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Cours } from '../../model/cours';
import { CoursService } from '../../service/cours.service';
import Swal from 'sweetalert2';
import { MatiereService } from '../../service/matiere.service';
import { Matiere } from '../../model/matiere';
import { Professeur } from '../../model/professeur';
import { ListCour } from '../../model/list-cour';
import { Classe } from '../../model/classes';
import { LabelValu } from '../../model/label-valu';
import { ClasseService } from '../../service/classe.service';
import { MultiSelectModule } from 'primeng/multiselect';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-gestion-cours',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule,MultiSelectModule],
  templateUrl: './gestion-cours.component.html',
  styleUrl: './gestion-cours.component.css'
})
export class GestionCoursComponent {
    // role: string
  coursForm!: FormGroup;
  selectedFile!: File;
  submitted: boolean = false;
  modelcours: Cours = new Cours();
  editing: boolean = false;
  editedCourId: number | null = null;
  matiereList: Matiere[] = [];
  profList: Professeur[] = [];
  coursList :Cours[]= [];
  coursListt:ListCour[]=[]
  imgUrl: string | ArrayBuffer = 'assets/logo.png'

  //| ArrayBuffer = 'assets/img/avatar.png'
  file!: File;
  classeList!: LabelValu[];
  classeListt:Classe[]=[];
  FormGroupClassMatiere!:FormGroup;
  idmatiere!:number;
  idclasse!:number;
 


  constructor(
    private coursService: CoursService, private classService: ClasseService,
    /*private seanceservice: SeanceService*/ private matierervice: MatiereService) { }


  ngOnInit(): void {
    //this.role = localStorage.getItem('role')
    this.coursForm = new FormGroup({
      'titre': new FormControl('', Validators.required),
      'urlcours': new FormControl('', Validators.required),
      'filecours': new FormControl('', Validators.required),
      'classesIds': new FormControl('', Validators.required),
      //'professeurId': new FormControl('', Validators.required),
      'matiereId': new FormControl('', Validators.required)
    });
    this.FormGroupClassMatiere= new FormGroup({
      'idclasse' : new FormControl('', Validators.required),
      'idMatiere' : new FormControl('', Validators.required),
   
    });
    this.getListMatere()
    this.getListprof();
    this.getListClasses()
    this.getListCours()
    this.getListclasse()


  }
  saveCours() {
    console.log("heloooooooo",this.coursForm.value);
    if (this.coursForm.invalid && this.submitted == true) {
   
      return;
    }
    this.modelcours.titre = this.coursForm.value.titre
    this.modelcours.urlcours = this.coursForm.value.urlcours
    this.modelcours.filecours = this.coursForm.value.filecours
    this.modelcours.classesIds = this.coursForm.value.classesIds
    //this.modelcours.professeurId = this.coursForm.value.professeurId
    this.modelcours.matiereId = this.coursForm.value.matiereId
    this.coursService.createCoursDto(this.modelcours)
        .subscribe({
          next: (res) => {
            console.log('ridha',this.file)
            console.log(res)
            this.coursService.uploadCoursDtoFile(res.id, this.file).subscribe(
              val =>  {} , error => { alert('oups')} , () => {
                this.submitted = true ;
                console.log('akka mouna',this.file)
              alert("produit a été ajouté!")
              // this.router.navigate(['/vendeur/gererarticle']);
               // this.FormGroupart.reset();
             //   this.toastrService.success('Success!', 'produit a été ajouté!');
              });
           
          },
        });}








  //////////// GET LIST COURS ////////
 getListCours(){
  this.coursService.findAllCoursDto().subscribe(res => {
    this.coursList = res
    console.log('liste de cours',res)
   
  } , error => {
      console.error(error)
  } , ()=> {


  })
 }






//////////GET LIST CLASSES///////////
  getListClasses() {
    this.classService.findallclasses().subscribe(res => {
      this.classeList = res
      console.log(res)
    }, error => {
      console.error(error)
    }, () => {
    })
  }
 ////// GET LIST PROFS //////////
  getListprof() {
    this.coursService.findAllprof().subscribe(res => {
      this.profList = res
      console.log(res)


    }, error => {
      console.error(error)
    },) }
  ////// ON FILE INPUT ///////////
  onFileInput(files: FileList | null): void {
    // alert("1" + JSON.stringify(files))
    if (files) {
      //  alert("2" + JSON.stringify(files))
      this.file = files.item(0) as File;
      if (this.file) {
        const fileReader = new FileReader();
        fileReader.readAsDataURL(this.file);
        fileReader.onload = (event) => {
          if (fileReader.result) {
            this.imgUrl = fileReader.result;
          }
        };
      }
    }
  }
  recupeIdclasseIdmatiere(){


    this.idmatiere =this.FormGroupClassMatiere.value.idMatiere
    this.idclasse= this.FormGroupClassMatiere.value.idclasse
    if (this.idmatiere && this.idclasse){
      this.getListCourByclasseAndMatiere(this.idmatiere, this.idclasse)
    }
  }
  // recupeIdclasseIdmatiere(){


  //   this.idmatiere =this.FormGroupClassMatiere.value.idclasse
  //   this.idclasse= this.FormGroupClassMatiere.value.idMatiere
  //   if (this.idmatiere && this.idclasse){
  //     this.getListDevoirByclasseAndMatiere(this.idmatiere, this.idclasse)
  //   }
  // }
  getListCourByclasseAndMatiere(idclasse:number, idMatiere: number)
{
 
  this.coursService.findAllCoursByclasseAndmatiere(idclasse,idMatiere).subscribe(res => {
    this.coursListt = res
    console.log("rimaaaaaaaa",res)
   
  } , error => {
      console.error(error)
  } , ()=> {


  })
}
  changeSource(event: any) {
    event.target.src = "assets/logo.png";
  }
  getListclasse() {
    this.classService.getAllClasse().subscribe(res => {
      this.classeListt = res
      console.log(res)
    }, error => {
      console.error(error)
    }, () => {
    })
  }
  getListMatere()
{
  this.matierervice.getAllMatiere().subscribe(res => {
    this.matiereList = res
    console.log("ghaithhhhhh",res)
   
  } , error => {
      console.error(error)
  } , ()=> {


  })
}


}

