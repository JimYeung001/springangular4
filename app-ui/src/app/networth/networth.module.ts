import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NetworthRoutingModule } from './networth-routing.module';
import { NetworthListComponent } from './networth-list/networth-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  imports: [
    CommonModule,
    NetworthRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [NetworthListComponent]
})
export class NetworthModule { }
