import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { fromEvent, Subject, takeUntil } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  user: any = {
    username: '',
    email: '',
    roles: ['user'],
    password: '',
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(
    private signupService: AuthService,
    private router: Router,
    private authService: AuthService
  ) {}
  
  ngOnInit(): void {

  }

  onCreateAccount() {
    this.authService.registerUser(this.user).subscribe({
      next: (data) => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.goToProductList();
      }
    });
  }

  goToProductList() {
    this.router.navigate(['login']);
  }
}
