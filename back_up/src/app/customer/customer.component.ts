import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers: Customer[] = [];
  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.customerService.getEmployeesList().subscribe(data => this.customers = data,
      error => console.log(error)
    )
  }

  updateCustomer(id: number) {
    this.router.navigate(['update-customer', id])
  }

  deleteCust(id: number) {
    this.customerService.deleteCustomer(id).subscribe(data => {
      this.customerService.getEmployeesList().subscribe(data => this.customers = data,
        error => console.log(error)
      )
    }, error => console.log(error))
  }

  getCustomerDetails(id:number){
    this.router.navigate(['customer-details',id])
  }

}
