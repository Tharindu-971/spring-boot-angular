import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuickViewComponent } from './common/quick-view/quick-view.component';
import { DetaiComponent } from './home/detai/detai.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: DetaiComponent },
  { path: 'home', component: DetaiComponent },
  { path: 'detail', component: QuickViewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
