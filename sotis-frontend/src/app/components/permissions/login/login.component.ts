import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Ucenik } from 'src/app/model/Ucenik';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;

  constructor(private registerService: RegisterService, private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {

    this.loginForm = this.formBuilder.group({
      lozinka: [''],
      email: [''],
    }, {

    });
  }


  login() {

    let korisnik = {
      id: 0,
      ime: "",
      prezime: "",
      lozinka: this.loginForm.value.lozinka,
      email: this.loginForm.value.email
    }

    this.registerService.login(korisnik).subscribe(data => {
      localStorage.setItem('loggedIn', data.toString());
      this.router.navigate(['/home'])
    })
  }

}
