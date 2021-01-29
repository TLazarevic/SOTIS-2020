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

    let ucenik = {
      id: 0,
      prostorZnanja: [],
      ime: "",
      prezime: "",
      lozinka: this.loginForm.value.lozinka,
      email: this.loginForm.value.email
    }

    this.registerService.login(ucenik).subscribe(data => {
      localStorage.setItem('loggedIn', data.toString());
      console.log(localStorage.getItem("loggedIn"))
      this.router.navigate(['/home'])
    })
  }


}
