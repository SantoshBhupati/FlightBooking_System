import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private httpClient:HttpClient) { }

  addNewProfile(profile:{profileId:any,personalInfo:any,email:any,mobile:any,gender:any,mobileNo:any}){
    console.log(profile);
    return this.httpClient.post('http://localhost:6666/profile/add',profile);
  }

  getProfileById(profileId:any){
    console.log(profileId);
    return this.httpClient.get('http://localhost:6666/profile/user/'+profileId);
  }

  updateProfile(profile:{profileId:any,personalInfo:any,email:any,mobile:any,gender:any,mobileNo:any}){
    return this.httpClient.put('http://localhost:6666/profile/update',profile);
  }
}
