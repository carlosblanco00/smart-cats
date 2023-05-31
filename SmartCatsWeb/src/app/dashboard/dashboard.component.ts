import { Component, OnInit, inject } from '@angular/core';
import { GatoDTO } from '../dominios/gatoDTO';
import { ConexionesGenericasServiceService } from '../conexiones-genericas-service.service';
import { movimientosDTO } from '../dominios/movimientosDTO';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

  public datosGato: GatoDTO = new GatoDTO();
  public moviGato: any[] = [];
  public arenero: movimientosDTO[] = [];
  public bebedero: movimientosDTO[] = [];
  public comedero: movimientosDTO[] = [];
  public fecha: Date = new Date('2023-05-30T19:38:26.4484');

  constructor(private conexion: ConexionesGenericasServiceService) {}

  ngOnInit(): void {
    this.infoGato();
    console.log(this.fecha.getDay());
  }

  infoGato(){
    this.conexion.getDatos("cat/1").subscribe(data => {
      this.datosGato = data;
    });
  }

}
