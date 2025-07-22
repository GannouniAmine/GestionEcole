import { Component, OnInit, ViewChild } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { Eleve, NiveauScolaire } from '../../model/eleve';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-signupeleve',
  standalone: true,
  imports: [FormsModule , CommonModule],
  templateUrl: './signupeleve.component.html',
  styleUrl: './signupeleve.component.css'
})
export class SignupeleveComponent  implements OnInit {
  @ViewChild('signInNgForm') signInNgForm!: NgForm;
  eleve : Eleve = new Eleve();
  niveaux = Object.values(NiveauScolaire);
  constructor(private authService : AuthService) { }

  ngOnInit(): void {
    // Initialization logic can go here
  }
  showAlert = false;
  message = '';
  isSubmitting = false;


  signUpEleve(): void {
    console.log("Login method called" , this.eleve);
    if (this.signInNgForm.invalid) {
      this.signInNgForm.control.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;
    this.showAlert = false;

    this.authService.signUpEleve(this.eleve).subscribe({
      next: (response) => {
        //const decodedToken = jwtDecode<CustomJwtPayload>(token);

        //const role = decodedToken.authorities[0].authority;
        //localStorage.setItem("role", role);

        //this._router.navigateByUrl('dashboard/welcome');
      },
      error: (error) => {
        console.error("Erreur de connexion :", error);

        this.isSubmitting = false;
        this.signInNgForm.resetForm();

        this.message = "Email ou mot de passe incorrect.";
        this.showAlert = true;
      }
    });
  }
}
