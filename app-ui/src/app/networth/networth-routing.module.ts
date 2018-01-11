import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NetworthListComponent } from './networth-list/networth-list.component';
import { NetworthEditComponent } from './networth-edit/networth-edit.component';

const routes: Routes = [
  {path: 'networth', component: NetworthListComponent},
  {path: 'networth/edit/:id', component: NetworthEditComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NetworthRoutingModule { }
