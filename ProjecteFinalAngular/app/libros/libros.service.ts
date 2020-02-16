import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Libro } from './libro';

@Injectable({
  providedIn: 'root'
})
export class LibrosService {

  private baseUrl = 'http://localhost:8080/libros';

  constructor(private http: HttpClient) {}

  getAllLibros(){
    return this.http.get<Libro[]>(this.baseUrl);
  }

  getLibroById(isbn:number){
    return this.http.get<Libro>(this.baseUrl+'/'+ isbn);
  }

  getLibroByName(nombre: string){
    return this.http.get<Libro[]>(this.baseUrl+'/nombre/'+ nombre);
  }

  createLibro(libro:Libro){
    return this.http.post<Libro>(this.baseUrl, libro);
  }

  updateLibro(libro: Libro, isbn: number){
    return this.http.put<Libro>(this.baseUrl+'/'+isbn, libro);
  }

  deleteLibro(isbn: number){
    return this.http.delete<boolean>(this.baseUrl+'/'+isbn);
  }
}
