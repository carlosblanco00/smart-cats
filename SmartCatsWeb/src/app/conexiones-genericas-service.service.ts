import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConexionesGenericasServiceService {

  rutaApi = "";

  constructor(private http: HttpClient) {}

  get(ruta: string) {
    return this.http.get(`${this.rutaApi}/${ruta}`);
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
