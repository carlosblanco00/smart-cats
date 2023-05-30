import { Component, OnInit } from '@angular/core';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { ConexionesGenericasServiceService } from 'src/app/conexiones-genericas-service.service';

@Component({
  selector: 'app-comedero-dash',
  templateUrl: './comedero-dash.component.html',
  styleUrls: ['./comedero-dash.component.css']
})
export class ComederoDashComponent implements OnInit {
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
        max: 8,
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

    this.barChartDataComedero = [{ data: [3, 5, 4, 6, 2, 4, 7], borderColor: 'blue' }];
    this.barChartDataComederoTanque = [{ data: [70, 30], backgroundColor: ['#06C6B5 ','#BDC205'] }];
  }

}
