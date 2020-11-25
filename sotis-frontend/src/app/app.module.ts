import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { TestsPreviewComponent } from './components/tests-preview/tests-preview.component';
import { LoginComponent } from './components/permissions/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    TestsPreviewComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
