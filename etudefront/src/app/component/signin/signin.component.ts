import { Component, OnInit, ViewChild } from '@angular/core';
import { Authrequest } from '../../model/authrequest';
import { AuthService } from '../../service/auth.service';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-signin',
  standalone: true,
  imports: [FormsModule , CommonModule],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css'
})
export class SigninComponent implements OnInit {
  @ViewChild('signInNgForm') signInNgForm!: NgForm;
  authrequest: Authrequest = new Authrequest();

  constructor(private authService : AuthService) { }

  ngOnInit(): void {
    // Initialization logic can go here
  }

  showAlert = false;
  message = '';
  isSubmitting = false;


  login(): void {
    console.log("Login method called" , this.authrequest);
    if (this.signInNgForm.invalid) {
      this.signInNgForm.control.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;
    this.showAlert = false;

    this.authService.signIn(this.authrequest).subscribe({
      next: (response) => {
        const token = response.accessToken;
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

