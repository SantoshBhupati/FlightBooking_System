import { Component } from '@angular/core';
import { AdminserviceService } from '../adminservice.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-deleteflight',
  templateUrl: './deleteflight.component.html',
  styleUrls: ['./deleteflight.component.css']
})
export class DeleteflightComponent {
  deleteid:any;
  constructor(private admin:AdminserviceService,private router:Router){}

  deleteFlight(){
    this.admin.delete(this.deleteid).subscribe(data=>{
      this.deleteid=data;
      console.log(data);
    })
    alert("Deleted!!");
    this.router.navigate(['show'])
  }
}
