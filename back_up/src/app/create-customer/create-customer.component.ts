import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customer : Customer = new Customer()
  constructor(private customerService:CustomerService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.customerService.createCustomer(this.customer).subscribe(data => {
      console.log(data)
      this.router.navigate(['/customers'])
    })
  }

}
