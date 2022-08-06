import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { FormsModule } from '@angular/forms';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    CreateCustomerComponent,
    UpdateCustomerComponent,
    CustomerDetailsComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, HttpClientModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
