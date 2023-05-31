import { Component, Input, OnInit } from '@angular/core';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { ConexionesGenericasServiceService } from 'src/app/conexiones-genericas-service.service';
import { movimientosDTO } from 'src/app/dominios/movimientosDTO';

@Component({
  selector: 'app-comedero-dash',
  templateUrl: './comedero-dash.component.html',
  styleUrls: ['./comedero-dash.component.css']
})
export class ComederoDashComponent implements OnInit {

  @Input() data : movimientosDTO[] = [];
  public arregloDias : number[] = [];
  public lun : number = 0;
  public mar : number = 0;
  public mier : number = 0;
  public jue : number = 0;
  public vie : number = 0;
  public sab : number = 0;
  public dom : number = 0;

  public moviGato: any[] = [];
  public comedero: movimientosDTO[] = [];

  public barChartOptionsComedero: ChartOptions = {
    responsive: true,
    scales: {
      x: {
        grid: {
          display: true,
          color: '#F3F3F3',
        },
      },
      y: {
        grid: {
          display: true,
          color: '#F3F3F3',
        },
        min: 0,
        max: 20,
      },
    },
  };

  public barChartLabelsComedero: string[] = [
    'Lunes',
    'Martes',
    'Miercoles',
    'Jueves',
    'Viernes',
    'Sabado',
    'Domingo',
  ];
  //Tipo de grafico que queremos: ejem: line, bar, radar
  public barChartTypeComedero: ChartType = 'line';
  public barChartLegendComedero = false;
  public barChartDataComedero: ChartDataset[] = [];

  public barChartOptionsComederoTanque: ChartOptions = {
    responsive: true,
    plugins: {
      tooltip: {
        enabled: false
      }
    }
  };

  public barChartLabelsComederoTanque: string[] = [
    'Lleno',
    'Vacío'
  ];
  //Tipo de grafico que queremos: ejem: line, bar, radar
  public barChartTypeComederoTanque: ChartType = 'doughnut';
  public barChartLegendComederoTanque = true;
  public barChartDataComederoTanque: ChartDataset[] = [];

  constructor(private conexion: ConexionesGenericasServiceService) {}

  ngOnInit(): void {

    //this.barChartDataComedero = [{ data: [3, 5, 4, 6, 2, 4, 7], borderColor: 'blue' }];
    this.barChartDataComederoTanque = [{ data: [70, 30], backgroundColor: ['#06C6B5 ','#BDC205'] }];
    this.movimientosComponente(1);
  }

  movimientosComponente(idGato : number){
    this.conexion.get("movements/"+ idGato.toString()).subscribe(data => {
      
      this.moviGato = data ;
      console.log(this.moviGato);
      this.organizarData();
    });
    
  }

  organizarData(){
    
    this.moviGato.forEach(element => {
      if(element.componente == "C"){
        this.comedero.push(element);
      }
    });
    this.organizarData2();

  }

  organizarData2(){
    this.comedero.forEach(dat => {
      let fecha = new Date(dat.createdAt);
      this.arregloDias.push(fecha.getDay());
    });

    this.arregloDias.forEach(veces => {
      switch (veces){
        case 0: 
          this.dom = this.dom + 1;
          break;
        case 1: 
          this.lun = this.lun + 1;
          break;
        case 2: 
          this.mar =  this.mar + 1;
          break;
        case 3:
          this.mier = this.mier + 1;
          break;
        case 4:  
          this.jue = this.jue + 1;
          break;
        case 5:
          this.vie =  this.vie + 1;
          break;
        case 6:
          this.sab =  this.sab + 1 ;
          break;
        default : break;

      }
    })

    this.barChartDataComedero = [{ data: [this.dom, this.lun, this.mar, this.mier, this.jue, this.vie, this.sab]}];
  }

}
