export class Usuario {

  id: number = 0;
  nombre: string = '';
  rol: number = 0;
  nombreCompleto = '';
  estado: boolean = false;
  password = '';
  id_vivero: number = 0;
}

export interface LoginI {
  nombre: string;
  password: string;
}
