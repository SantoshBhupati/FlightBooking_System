import { Component } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { Router } from '@angular/router';
import { FlightDetails } from '../model/flightDetails';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent {
  td: any = new FlightDetails();

  constructor(private adminservice:AdminserviceService,private router:Router){}


  addFlights(){
    this.adminservice.addFlight(this.td).subscribe(data=>{
      console.log(data);
      alert("Flight Details added successFully");
      this.router.navigate(['show'])
  });
}
}
