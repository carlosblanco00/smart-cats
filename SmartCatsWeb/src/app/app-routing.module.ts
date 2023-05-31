import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ConfiguracionComponent } from './configuracion/configuracion.component';


const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent},
  { path: 'configuracion', component: ConfiguracionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
