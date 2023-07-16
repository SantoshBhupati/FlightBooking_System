import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FrontPageComponent } from './front-page/front-page.component';
import { LoginComponent } from './login/login.component';

import { RegisterComponent } from './register/register.component';
// import { AddtrainsComponent } from './addtrains/addtrains.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
// import { ShowTrainsComponent } from './show-trains/show-trains.component';
import { CancelticketComponent } from './cancelticket/cancelticket.component';
// import { DeletetrainComponent } from './deletetrain/deletetrain.component';
// import { SearchtrainComponent } from './searchtrain/searchtrain.component';
// import { UpdatetrainComponent } from './updatetrain/updatetrain.component';
import { ShowFlightComponent } from './show-flight/show-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { DeleteflightComponent } from './deleteflight/deleteflight.component';
import { SearchflightComponent } from './searchflight/searchflight.component';
import { BookticketComponent } from './bookticket/bookticket.component';

const routes: Routes = [
  {path:"signup",component:RegisterComponent},
  {path:"login",component:LoginComponent},
  {path:"addTrains",component:AddFlightComponent},
  {path:"",component:FrontPageComponent},
  {path:"show",component:ShowFlightComponent},
  {path:"cancel",component:CancelticketComponent},
  {path:"delete",component:DeleteflightComponent},
  {path:"search",component:SearchflightComponent},
  {path:"update",component:UpdateFlightComponent},
  {path:"book",component:BookticketComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
