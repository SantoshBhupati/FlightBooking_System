import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
// import { TrainDetails } from './model/trainDetails';
import { FlightDetails } from './model/flightDetails';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  id:any;

  constructor(private http: HttpClient) { }

  saveID(ID:any){ 
    this.id=ID;
  }

  returnID(){
    return this.id;
  }

  get(){
    return this.http.get<FlightDetails[]>("http://localhost:8001/show");
  }

  addFlight(td:FlightDetails){
    return this.http.post<FlightDetails>("http://localhost:8001/add",td);
  }

  delete(id:any){
    return this.http.delete("http://localhost:8001/delete/"+id);
  }

  getById(id:any){
    return this.http.get<FlightDetails>("http://localhost:8001/findbyid/"+id);
  }

  updateFlight(id:any, flight:FlightDetails){
    return this.http.put<FlightDetails>("http://localhost:8001/update/"+id,flight);
  }
}
