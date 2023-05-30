import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { NavegacionComponent } from './navegacion/navegacion.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { InicioComponent } from './inicio/inicio.component';
import { ConfiguracionComponent } from './configuracion/configuracion.component';
import { AppRoutingModule } from './app-routing.module';
import { ComederoComponent } from './configuracion/comedero/comedero.component';
import { AreneroComponent } from './configuracion/arenero/arenero.component';
import { BebederoComponent } from './configuracion/bebedero/bebedero.component';
import { MatTabsModule } from '@angular/material/tabs';
import { NgChartsModule } from 'ng2-charts';
import { AreneroDashComponent } from './dashboard/arenero-dash/arenero-dash.component';
import { ComederoDashComponent } from './dashboard/comedero-dash/comedero-dash.component';
import { BebederoDashComponent } from './dashboard/bebedero-dash/bebedero-dash.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    NavegacionComponent,
    InicioComponent,
    ConfiguracionComponent,
    ComederoComponent,
    AreneroComponent,
    BebederoComponent,
    AreneroDashComponent,
    ComederoDashComponent,
    BebederoDashComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    AppRoutingModule,
    MatTabsModule,
    NgChartsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
