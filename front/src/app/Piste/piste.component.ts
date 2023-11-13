import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-piste',
  templateUrl: './piste.component.html',
  styleUrls: ['./piste.component.css']
})
export class PisteComponent implements OnInit {
  pistes: any[] = [];
  newPiste: any = {};

  constructor(private pisteService: ServiceService) {}

  ngOnInit(): void {
    this.loadPistes();
  }

  loadPistes() {
    this.pisteService.getAllPistes().subscribe((data) => {
      this.pistes = data;
    });
  }

  addPiste() {
    this.pisteService.addPiste(this.newPiste).subscribe(() => {
      this.newPiste = {}; // Réinitialise le formulaire après l'ajout
      this.loadPistes();
    });
  }
}

