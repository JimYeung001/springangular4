import { Component, OnInit } from '@angular/core';
import { NetWorth } from '../networth-model/net-worth';
import { NetworthService } from '../networth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-networth-list',
  templateUrl: './networth-list.component.html',
  styleUrls: ['./networth-list.component.css'],
  providers: [NetworthService]
})
export class NetworthListComponent implements OnInit {

  private networths: NetWorth[];

  constructor(private networthService: NetworthService,
    private router: Router) { }

  ngOnInit() {
    this.findAll();
  }

  findAll() {
    this.networthService.findAll().subscribe(
      networths => {
        this.networths = networths;
      },
      err => { console.log(err) }
    );
  }

  editNetworth(networth: NetWorth) {
    this.router.navigate(['/networth/edit', networth.id])
  }

}
