import { Routes } from '@angular/router';
import { SigninComponent } from './component/signin/signin.component';
import { SignupeleveComponent } from './component/signupeleve/signupeleve.component';
import { SignupparentComponent } from './component/signupparent/signupparent.component';

import { GestionCoursComponent } from './component/gestion-cours/gestion-cours.component';
import { GestionClasseComponent } from './component/gestion-classe/gestion-classe.component';
import { GestionMatiereComponent } from './component/gestion-matiere/gestion-matiere.component';
import { SignupprofesseurComponent } from './component/signupprofesseur/signupprofesseur.component';
import { GestionParentComponent } from './component/gestion-parent/gestion-parent.component';
import { GestionReglementComponent } from './component/gestion-reglement/gestion-reglement.component';
export const routes: Routes = [
    {path: 'login', component: SigninComponent},
    {path: 'registereleve', component: SignupeleveComponent},
    {path: 'registerparent', component: SignupparentComponent},
    {path : 'gestionclasse' , component : GestionClasseComponent},
    {path : 'gestionmatiere' , component : GestionMatiereComponent},
    {path : 'gestioncours' , component : GestionCoursComponent},
    {path : 'registerprofesseur' , component : SignupprofesseurComponent},
    {path : 'gestionparent', component: GestionParentComponent},
    {path : 'gestionreglement', component: GestionReglementComponent},
];
