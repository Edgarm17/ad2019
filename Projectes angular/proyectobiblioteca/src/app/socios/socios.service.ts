import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Socio } from './socio';

@Injectable({
  providedIn: 'root'
})
export class SociosService {

  private baseUrl = 'http://localhost:8080/socios';

  constructor(private http: HttpClient) {}

  getAllSocios(){
    return this.http.get<Socio[]>(this.baseUrl);
  }

  getSocioById(numsocio:number){
    return this.http.get<Socio>(this.baseUrl+'/'+ numsocio);
  }

  getSocioByName(nombre: string){
    return this.http.get<Socio[]>(this.baseUrl+'/nombre/'+ nombre);
  }

  createSocio(socio:Socio){
    return this.http.post<Socio>(this.baseUrl, socio);
  }

  updateSocio(socio: Socio, numsocio: number){
    return this.http.put<Socio>(this.baseUrl+'/'+numsocio, socio);
  }

  deleteSocio(numsocio: number){
    return this.http.delete<boolean>(this.baseUrl+'/'+numsocio);
  }
}