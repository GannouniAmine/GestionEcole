import { Registerrequest } from "./registerrequest";

export class Eleve extends Registerrequest {
    dob!: Date;
    typePaiement!: string;
    niveauScolaire!: NiveauScolaire;
    statutPaiement!: string;
    statutAffectation!: string;  
}
export enum NiveauScolaire {
  PREMIERE_BASE = 'PREMIERE_BASE',
  DEUXIEME_BASE = 'DEUXIEME_BASE',
  TROISIEME_BASE = 'TROISIEME_BASE',
  QUATRIEM_BASE = 'QUATRIEM_BASE',
  CINQUIEM_BASE = 'CINQUIEM_BASE',
  SIXIEME_BASE = 'SIXIEME_BASE'
}