import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-cancelticket',
  templateUrl: './cancelticket.component.html',
  styleUrls: ['./cancelticket.component.css']
})
export class CancelticketComponent {

  cancellationid:any;

  constructor(private user:UserService,private router:Router){}

  onCancelBooking(){
    this.user.get(this.cancellationid).subscribe(data=>{
      this.cancellationid=data;
      console.log(data);
    })
    alert("Your Booking has been cancelled Successfully, You'll receive a confirmation mail for it ");
    this.goto();
  }

  goto(){
    this.router.navigate(['']);
  }
}
