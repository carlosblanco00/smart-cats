import { Component, OnInit } from '@angular/core';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { ConexionesGenericasServiceService } from 'src/app/conexiones-genericas-service.service';

@Component({
  selector: 'app-bebedero-dash',
  templateUrl: './bebedero-dash.component.html',
  styleUrls: ['./bebedero-dash.component.css']
})
export class BebederoDashComponent implements OnInit {
  public barChartOptionsBebedero: ChartOptions = {
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

  public barChartLabelsBebedero: string[] = [
    'Lunes',
    'Martes',
    'Miercoles',
    'Jueves',
    'Viernes',
    'Sabado',
    'Domingo',
  ];
  //Tipo de grafico que queremos: ejem: line, bar, radar
  public barChartTypeBebedero: ChartType = 'line';
  public barChartLegendBebedero = false;
  public barChartDataBebedero: ChartDataset[] = [];

  public barChartOptionsBebederoTanque: ChartOptions = {
    responsive: true,
    plugins: {
      tooltip: {
        enabled: false
      }
    }
  };

  public barChartLabelsBebederoTanque: string[] = [
    'Lleno',
    'Vacío'
  ];
  //Tipo de grafico que queremos: ejem: line, bar, radar
  public barChartTypeBebederoTanque: ChartType = 'doughnut';
  public barChartLegendBebederoTanque = true;
  public barChartDataBebederoTanque: ChartDataset[] = [];

  constructor(private conexion: ConexionesGenericasServiceService) {}

  ngOnInit(): void {

    this.barChartDataBebedero = [{ data: [3, 5, 4, 6, 2, 4, 7], borderColor: 'blue' }];
    this.barChartDataBebederoTanque = [{ data: [70, 30], backgroundColor: ['#06C6B5 ','#BDC205'] }];
  }

}
