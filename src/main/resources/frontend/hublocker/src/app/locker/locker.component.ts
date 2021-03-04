import { Component, OnInit } from '@angular/core';
import {Locker} from "../locker";
import {LockerService} from "../locker.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-locker',
  templateUrl: './locker.component.html',
  styleUrls: ['./locker.component.css']
})
export class LockerComponent implements OnInit {

  public locationLockers : Locker[];
  constructor(private lockerService: LockerService) { }

  ngOnInit(): void {
    this.listAllLocationLockers();
  }

  public listAllLocationLockers():void{
    this.lockerService.getAllLocationLockers().subscribe(
      (response: Locker[]) => {
        this.locationLockers = response;
      },
      (error => console.log(error.message))
    )
  }

  public onEnterCityOrState(searchForm: NgForm): void{
    this.lockerService.getLockersByStateOrCity(searchForm.value.cityOrState)
      .subscribe((response:Locker[]) =>{ this.locationLockers = response },
        error => console.log(error.message));
  }

}
