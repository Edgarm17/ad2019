import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Prestamo } from './prestamo';

@Injectable({
  providedIn: 'root'
})
export class PrestamosService {

  private baseUrl = 'http://localhost:8080/prestamos';

  constructor(private http: HttpClient) {}

  getAllPrestamos(){
    return this.http.get<Prestamo[]>(this.baseUrl);
  }

  getPrestamoById(fprestamo:string){
    return this.http.get<Prestamo>(this.baseUrl+'/'+ fprestamo);
  }

  getPrestamoByFecha(fecha: string){
    return this.http.get<Prestamo[]>(this.baseUrl+'/fechas/'+ fecha);
  }

  createPrestamo(prestamo:Prestamo){
    return this.http.post<Prestamo>(this.baseUrl, prestamo);
  }

  updatePrestamo(prestamo: Prestamo, fprestamo: string){
    return this.http.put<Prestamo>(this.baseUrl+'/'+fprestamo, prestamo);
  }

  deletePrestamo(fprestamo: string){
    return this.http.delete<boolean>(this.baseUrl+'/'+fprestamo);
  }
}
