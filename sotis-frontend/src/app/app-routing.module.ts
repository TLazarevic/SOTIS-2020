import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TestPreviewComponent } from './components/test-preview/test-preview.component';
import { TestsPreviewComponent } from './components/tests-preview/tests-preview.component';

const routes: Routes = [
  { path: 'Tests', component: TestsPreviewComponent},
  { path: 'Test', component: TestPreviewComponent},
  { path: '', component: HomeComponent, pathMatch : 'full'},
  { path: '**', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
