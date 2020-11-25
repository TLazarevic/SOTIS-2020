import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TestsPreviewComponent } from './components/tests-preview/tests-preview.component';

const routes: Routes = [
  { path: 'Tests', component: TestsPreviewComponent},
  { path: '', component: HomeComponent, pathMatch : 'full'},
  { path: '**', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
