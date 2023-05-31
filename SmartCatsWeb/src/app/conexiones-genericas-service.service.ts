import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { movimientosDTO } from './dominios/movimientosDTO';

@Injectable({
  providedIn: 'root'
})
export class ConexionesGenericasServiceService {

  rutaApi = "http://10.23.11.43:8080/api/smartcats";

  constructor(private http: HttpClient) {}
  
  getDatos(ruta: string) {
    return this.http.get(`${this.rutaApi}/${ruta}`);
  }

  get(ruta: string) {
    return this.http.get<movimientosDTO[]>(`${this.rutaApi}/${ruta}`);
  }

  post(ruta: string, objeto: any) {
    return this.http.post(`${this.rutaApi}/${ruta}`, objeto);
  }

  update(ruta: string, objeto: any) {
    return this.http.put(`${this.rutaApi}/${ruta}`, objeto);
  }

  delete(ruta: string, id: string | number) {
    return this.http.delete(`${this.rutaApi}/${ruta}?id=${id}`);
  }
}
