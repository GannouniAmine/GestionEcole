import { CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { Parent } from '../../model/parent';

@Component({
  selector: 'app-signupparent',
  standalone: true,
  imports: [FormsModule , CommonModule],
  templateUrl: './signupparent.component.html',
  styleUrl: './signupparent.component.css'
})
export class SignupparentComponent {
   @ViewChild('signInNgForm') signInNgForm!: NgForm;
    parent :Parent = new Parent();
    constructor(private authService : AuthService) { }
  
    ngOnInit(): void {
      // Initialization logic can go here
    }
    showAlert = false;
    message = '';
    isSubmitting = false;
  
  
    signUpParent(): void {
      console.log("Login method called" , this.parent);
      if (this.signInNgForm.invalid) {
        this.signInNgForm.control.markAllAsTouched();
        return;
      }
  
      this.isSubmitting = true;
      this.showAlert = false;
  
      this.authService.signUpParent(this.parent).subscribe({
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
