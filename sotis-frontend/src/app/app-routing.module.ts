import { StudentKnowledgeSpaceComponent } from './components/student-knowledge-space/student-knowledge-space.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { KnowledgePreviewComponent } from './components/knowledge-preview/knowledge-preview.component';
import { RegisterComponent } from './components/permissions/register/register.component';
import { TestPreviewComponent } from './components/test-preview/test-preview.component';
import { TestsPreviewComponent } from './components/tests-preview/tests-preview.component';
import { NewTestComponent } from './new-test/new-test.component';
import { NewPitanjeComponent } from './new-pitanje/new-pitanje.component';
import { GraphComparisonComponent } from './components/graph-comparison/graph-comparison.component';
import { LoginComponent } from './components/permissions/login/login.component';

const routes: Routes = [
  { path: 'Tests', component: TestsPreviewComponent },
  { path: 'Test', component: TestPreviewComponent },
  { path: 'NewTest', component: NewTestComponent },
  { path: 'NewPitanje', component: NewPitanjeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'knowledge-graph', component: KnowledgePreviewComponent },
  { path: 'graph-comparison', component: GraphComparisonComponent },
  { path: 'student-ks', component: StudentKnowledgeSpaceComponent },
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
