import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RentSuccessComponent } from "./rent-success/rent-success.component";
import {LockerComponent} from "./locker/locker.component";
import {AppComponent} from "./app.component";

const routes: Routes = [
    {
      path: "", component: AppComponent,
      children: [
        {path: "", redirectTo: "/lockers", pathMatch: "full"},
        { path: "lockers", component: LockerComponent},
        { path: "rent-success", component: RentSuccessComponent},
      ]
    },

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
