import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.scss']
})
export class EmployeeDetailComponent implements OnInit {

  employee: Employee = { id: '', firstName: '', lastName: '', email: '' };
  isLoadingResults = true;

  constructor(private route: ActivatedRoute, private api: ApiService, private router: Router) { }

  getEmployeeDetails(id) {
    this.api.getEmployee(id)
      .subscribe(data => {
        this.employee = data;
        console.log(this.employee);
        this.isLoadingResults = false;
      });
  }

  deleteEmployee(id) {
    this.isLoadingResults = true;
    this.api.deleteEmployee(id)
      .subscribe(res => {
          this.isLoadingResults = false;
          this.router.navigate(['/employees']);
        }, (err) => {
          console.log(err);
          this.isLoadingResults = false;
        }
      );
  }

  ngOnInit() {
    this.getEmployeeDetails(this.route.snapshot.params['id']);
  }

}
