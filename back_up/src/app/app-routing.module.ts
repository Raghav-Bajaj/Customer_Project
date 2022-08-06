import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CustomerComponent } from './customer/customer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';

const routes: Routes = [
  { path:'customers', component: CustomerComponent },
  { path:'create-customer', component: CreateCustomerComponent },
  {path:'update-customer/:id', component: UpdateCustomerComponent},
  {path:'customer-details/:id', component:CustomerDetailsComponent},
  {path:'', redirectTo:'customers',pathMatch:'full'},
  {path:'**', pathMatch:'full', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
