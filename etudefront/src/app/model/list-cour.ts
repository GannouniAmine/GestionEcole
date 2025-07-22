import { Matiere } from "./matiere";
import { Professeur } from "./professeur";

export class ListCour {
    idCours! : number;
    titre! :String;
    urlcours!:String;
    filecours! :String;
    professeur!:Professeur;
    classesId!:number[];
    matiere!: Matiere[];

}
