import { Component, OnInit } from '@angular/core';
import { ChartType, ChartDataset, ChartOptions } from 'chart.js';
import { ConexionesGenericasServiceService } from 'src/app/conexiones-genericas-service.service';

@Component({
  selector: 'app-arenero-dash',
  templateUrl: './arenero-dash.component.html',
  styleUrls: ['./arenero-dash.component.css'],
})
export class AreneroDashComponent implements OnInit {
  public barChartOptions: ChartOptions = {
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

  public barChartLabels: string[] = [
    'Lunes',
    'Martes',
    'Miercoles',
    'Jueves',
    'Viernes',
    'Sabado',
    'Domingo',
  ];
  //Tipo de grafico que queremos: ejem: line, bar, radar
  public barChartType: ChartType = 'line';
  public barChartLegend = false;
  public barChartData: ChartDataset[] = [];

  public barChartOptionsTanque: ChartOptions = {
    responsive: true,
    plugins: {
      tooltip: {
        enabled: false
      }
    }
  };

  public barChartLabelsTanque: string[] = [
    'Lleno',
    'Vacío'
  ];
  //Tipo de grafico que queremos: ejem: line, bar, radar
  public barChartTypeTanque: ChartType = 'doughnut';
  public barChartLegendTanque = true;
  public barChartDataTanque: ChartDataset[] = [];

  constructor(private conexion: ConexionesGenericasServiceService) {}

  ngOnInit(): void {

    this.barChartData = [{ data: [3, 5, 4, 6, 2, 4, 7], borderColor: 'blue' }];
    this.barChartDataTanque = [{ data: [70, 30], backgroundColor: ['#06C6B5 ','#BDC205'] }];
  }
}
