import { Component } from '@angular/core';
import { Bookingdetails } from '../model/Bookingdetails';
import { UserService } from '../user.service';
import { Route, Router } from '@angular/router';
// import { TrainDetails } from '../model/trainDetails';
import { AdminserviceService } from '../adminservice.service';
declare var Razorpay:any;
@Component({
  selector: 'app-bookticket',
  templateUrl: './bookticket.component.html',
  styleUrls: ['./bookticket.component.css']
})
export class BookticketComponent {
  num:any;
  bk: any = new Bookingdetails;
  boo:Bookingdetails;
  // td:TrainDetails[];
  
  constructor(private user:UserService,private router:Router,private admin: AdminserviceService){}

  book(){
    this.user.bookFlight(this.bk).subscribe(data=>{
      this.boo=this.user.currentBooking();
      console.log(this.boo);
      this.createTransaction();
      alert("Booking done successFully Please Make the payment For the booking");
  });
}
createTransaction(){
    if(this.bk.flightName =="air asia"){
      this.num = 4000 * this.bk.numberOfTravellers;
    }else if(this.bk.flightName =="indigo"){
      this.num = 3000 * this.bk.numberOfTravellers;
    }else if(this.bk.flightName =="air india"){
      this.num = 1800 * this.bk.numberOfTravellers;
    }else if(this.bk.flightName == "spicejet"){
      this.num = 5000 * this.bk.numberOfTravellers;
    }
    // else if(this.bk.trainNo === 7897){
    //   this.num = 1200 * this.bk.numberOfTravellers;
    // }else{
    //   this.num = 350 * this.bk.numberOfTravellers;
    // }
    var response = this.user.createTransaction(this.num).subscribe(
      (response) =>{
        console.log(response);
        this.openTransactionModel(response);
      },
      (error) =>{
        console.log(error);
      }
    )
    this.router.navigate([''])
  }

  openTransactionModel(response:any){
    var options = {
      order_id:response.orderId,
      key:response.key,
      amount:response.amount,
      currency:response.currency,
      name: 'Santosh',
      description: "Payment Flight Booking",
      image: 'https://cdn.pixabay.com/photo/2023/06/18/04/57/crimson-collared-tanager-8071235_640.jpg',
      handler:(response :any)=>{
        this.processResponse(response);
      },
      prefill :{
        name:'Santosh',
        email:'bhupatis20@gmail.com',
        contact:'9604457045',
      },
      notes:{
        address:'Online train Booking'
      },
      theme:{
        color:"#F37254"
      }
    };

    var razorpay = new Razorpay(options);
    razorpay.open();
  }
  processResponse(resp:any){
    console.log(resp);
  }
}