import {Vivero, ViveroI} from "../vivero/vivero";

export class Usuario {

  nombre: string = '';
  password = '';
  nombreCompleto = '';
  rol: number = 0;
  estado: boolean = false;
  vivero: number = 0;


}

export interface UsuarioI {

  nombre: string;
  password: string;
  nombreCompleto: string;
  rol: number;
  estado: boolean;
  vivero: ViveroI;


}

export interface LoginI {
  nombre: string;
  password: string;
}
