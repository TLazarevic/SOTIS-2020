import { Component, OnInit } from '@angular/core';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  authorised!: boolean

  constructor(private registerService:RegisterService) {
    var loggedInUser = localStorage.getItem("loggedIn")
    if (loggedInUser != undefined && loggedInUser != null) {
      this.authorised = true
    } else {
      this.authorised = false
    }
  }

  ngOnInit(): void {
    var loggedInUser = localStorage.getItem("loggedIn")
    if (loggedInUser != undefined && loggedInUser != null) {
      this.authorised = true
    } else {
      this.authorised = false
    }
  }

  logout(){
    this.registerService.logout()
    this.ngOnInit()
  }

}
