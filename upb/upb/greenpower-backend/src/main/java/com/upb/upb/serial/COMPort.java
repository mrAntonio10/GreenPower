package com.upb.upb.serial;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.util.Scanner;

public class COMPort {
    public static void main(String[] args) throws InterruptedException, IOException {

        SerialPort sp = SerialPort.getCommPort("COM7"); //DEFINIMOS PUERTO COM
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if(!sp.openPort()){
            System.out.println("Puerto no disponible");
        }
        Scanner teclado = new Scanner(System.in);
        while(true){
            System.out.println("Ingrese numero de parpadeos de LED");
            Integer parpadeos = teclado.nextInt();
            if(parpadeos == 0) break;
            Thread.sleep(3000); //Actuador tarda en levantar
            sp.getOutputStream().write(parpadeos.byteValue());
        }
        teclado.close();
    }


}
