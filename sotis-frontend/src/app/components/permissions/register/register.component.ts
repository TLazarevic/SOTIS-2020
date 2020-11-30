import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegisterService } from 'src/app/services/register.service';
import { Ucenik } from 'src/app/model/Ucenik';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  loading = false;
  registerForm!: FormGroup;
  submitted = false;

  constructor(private _snackBar: MatSnackBar, private formBuilder: FormBuilder, private router: Router, private registerService: RegisterService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      lozinka: ['', [Validators.required, Validators.minLength(8), Validators.pattern('^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$'
      )]],
      lozinka2: ['', [Validators.required, Validators.minLength(8), Validators.pattern('^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$'
      )]],
      email: ['', [Validators.required, Validators.email]],
      ime: ['', Validators.required],
      prezime: ['', Validators.required],
    }, {

    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {


    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {

      alert(1)
      return;
    }

    this.loading = true;
    console.log(this.registerForm.value)
    this.registerService.register(new Ucenik(this.registerForm.value.ime, this.registerForm.value.ime))
      .pipe(first())
      .subscribe(
        data => {
          this._snackBar.open("Uspešno ste se registrovali! Molimo Vas ulogujte se kako biste koristili usluge kliničkog centra!", "", {
            duration: 3000
          });
          this.router.navigate(['/login']);
        },
        error => {
          this._snackBar.open("Greška prilikom registracije!", "", {
            duration: 3000
          });
          this.loading = false;
        });
  }

}
