import { Component } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { FlightDetails } from '../model/flightDetails';
import { UserService } from '../user.service';

@Component({
  selector: 'app-searchflight',
  templateUrl: './searchflight.component.html',
  styleUrls: ['./searchflight.component.css']
})
export class SearchflightComponent {
  td: FlightDetails[];

  sourceName:any;
  destinationName:any;
  constructor(private user:UserService) { }

  ngOnInit() {
    // Initialization code here if needed
  }

  searchData() {
    this.user.searchFlight(this.sourceName,this.destinationName).subscribe(data => {
      this.td = data;
      console.log(data);
    });
  }
}
