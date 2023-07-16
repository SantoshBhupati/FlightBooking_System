import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
// import { TrainDetails } from './model/trainDetails';
import { FlightDetails } from './model/flightDetails';
import { Bookingdetails } from './model/Bookingdetails';
import { TransactionDetails } from './model/transactiondetails';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  book:Bookingdetails;
  constructor(private http: HttpClient) { }

  get(id:any){
    return this.http.delete("http://localhost:8002/cancelbooking/"+id);
  }

  searchFlight(source:any,destination:any){
    return this.http.get<FlightDetails[]>("http://localhost:8002/findbysourceanddestination/"+source+"/"+destination);
  }
  currentBooking(){
    return this.book;
  }
  public createTransaction(amount:any){
    return this.http.get<TransactionDetails>("http://localhost:8003/createTransaction/"+amount);
  }
  bookFlight(bk:Bookingdetails){
    this.book = bk;
    return this.http.post<Bookingdetails>("http://localhost:8002/book",bk);
  }
}
