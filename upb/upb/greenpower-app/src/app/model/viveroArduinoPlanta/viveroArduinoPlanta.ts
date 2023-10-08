import {Planta} from "../planta/planta";
import {Vivero} from "../vivero/vivero";
import {Arduino} from "../arduino/arduino";

export class ViveroArduinoPlanta {

  id: number = 0;

  //otros
  //@ts-ignore
  arduino: Arduino;
  // @ts-ignore
  planta: Planta;

}
