import { Component } from '@angular/core';
import { FlightDetails } from '../model/flightDetails';
import { AdminserviceService } from '../adminservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent {
  flight:FlightDetails;
  id:any;

  constructor(private admin:AdminserviceService,private router:Router){}

  ngOnInit() {
    this.flight = new FlightDetails;
    this.id = this.admin.returnID();
    this.admin.getById(this.id).subscribe(data=>{
      this.flight = data;
    })
  }

  updateFlight(){
   this.admin.updateFlight(this.id,this.flight).subscribe(data=>{
    console.log(data);
   });
   this.router.navigate(['show'])
  }
  onSubmit() {
    this.updateFlight();
  }
}
