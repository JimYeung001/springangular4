import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NetworthModule } from './networth/networth.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ErrorComponent } from './error-component';
import { NetworthEditComponent } from './networth/networth-edit/networth-edit.component'
import { NumberOnly } from './number-only.derective';
import { CapitalizePipe } from './capitalize-piple';
import { FieldNameFilter } from './field-name-filter';


@NgModule({
  declarations: [
    AppComponent,
    ErrorComponent,
    NetworthEditComponent,
    NumberOnly,
    CapitalizePipe,
    FieldNameFilter
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NetworthModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
