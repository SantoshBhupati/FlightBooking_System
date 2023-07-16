import { Component } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { FlightDetails } from '../model/flightDetails';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-show-flight',
  templateUrl: './show-flight.component.html',
  styleUrls: ['./show-flight.component.css']
})
export class ShowFlightComponent {
  td:FlightDetails[];

  constructor(private admin: AdminserviceService,private router:Router){}

  ngOnInit(){
    this.showData();
  }

  showData(){
    this.admin.get().subscribe(data=>{
      this.td=data;
      console.log(data);
    });
  }

  updateUser(id: any) {
    this.admin.saveID(id);
    this.router.navigate(['update']);
  }
}
