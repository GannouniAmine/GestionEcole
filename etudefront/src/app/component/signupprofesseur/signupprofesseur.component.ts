import { Component, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Professeur } from '../../model/professeur';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-signupprofesseur',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './signupprofesseur.component.html',
  styleUrl: './signupprofesseur.component.css'
})
export class SignupprofesseurComponent {
  @ViewChild('signInNgForm') signInNgForm!: NgForm;
      professeur : Professeur = new Professeur();
      constructor(private authService : AuthService) { }
    
      ngOnInit(): void {
        // Initialization logic can go here
      }
      showAlert = false;
      message = '';
      isSubmitting = false;
    
    
      signUpProfesseur(): void {
        console.log("Login method called" , this.professeur);
        if (this.signInNgForm.invalid) {
          this.signInNgForm.control.markAllAsTouched();
          return;
        }
    
        this.isSubmitting = true;
        this.showAlert = false;
    
        this.authService.signUpProfesseur(this.professeur).subscribe({
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
