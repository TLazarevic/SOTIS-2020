import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { KnowledgePreviewComponent } from './components/knowledge-preview/knowledge-preview.component';
import { RegisterComponent } from './components/permissions/register/register.component';
import { TestPreviewComponent } from './components/test-preview/test-preview.component';
import { TestsPreviewComponent } from './components/tests-preview/tests-preview.component';
import { NewTestComponent } from './new-test/new-test.component';

const routes: Routes = [
  { path: 'Tests', component: TestsPreviewComponent },
  { path: 'Test', component: TestPreviewComponent },
  { path: 'NewTest', component: NewTestComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'knowledge-graph', component: KnowledgePreviewComponent },
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
