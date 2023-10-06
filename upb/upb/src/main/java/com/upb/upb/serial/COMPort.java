package com.upb.upb.serial;


public class COMPort {
//    private static final String DB_URL = "jdbc:postgresql://192.168.201.40:5432/pruebaGreen";
//    private static final String DB_USER = "marcoro";
//    private static final String DB_PASSWORD = "4708";
//
//    public static void main(String[] args) throws InterruptedException, IOException {
//        SerialPort sp = SerialPort.getCommPort("COM8"); //DEFINIMOS PUERTO COM
//        sp.setComPortParameters(9600, 8, 1, 0);
//        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
//
//        if (!sp.openPort()) {
//            System.out.println("Puerto no disponible");
//        }
//
//        Scanner teclado = new Scanner(System.in);
//
//        // Configura un oyente para recibir datos del puerto serial
//        sp.addDataListener(new SerialPortDataListener() {
//            @Override
//            public int getListeningEvents() {
//                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
//            }
//
//            @Override
//            public void serialEvent(SerialPortEvent event) {
//                if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
//                    byte[] newData = new byte[sp.bytesAvailable()];
//                    int numRead = sp.readBytes(newData, newData.length);
//                    String data = new String(newData, 0, numRead);
//                    System.out.print(data);
//                    // Inserta los datos en la base de datos
//                    insertDataIntoDatabase(data);
//                }
//            }
//        });
//
//        // Espera para recibir datos del Arduino
//        try {
//            Thread.sleep(2000); // Espera durante 2 segundos (ajusta el tiempo según tus necesidades)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void insertDataIntoDatabase(String data) {
//        System.out.println("Vamos a ingresar: "+data);
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//            if (connection != null) {
//                String insertQuery = "INSERT INTO prueba_sensor(nombre, medida) VALUES (?, 0)";
//                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
//                preparedStatement.setString(1, data);
//                // Ejecuta la inserción
//                preparedStatement.executeUpdate();
//                System.out.println("Datos insertados en la base de datos: " + data);
//            } else {
//                System.out.println("Error al conectar a la base de datos.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}

//@Slf4j
//@RestController
//public class COMPort {
//    @Autowired
//    PruebaSensorServiceImpl pruebaSensorService = new PruebaSensorServiceImpl();
//
//
//    public static void main(String[] args) throws InterruptedException, IOException {
//        //prueba
//        COMPort comPort = new COMPort();
//
//        SerialPort sp = SerialPort.getCommPort("COM6"); //DEFINIMOS PUERTO COM
//        sp.setComPortParameters(9600, 8, 1, 0);
//        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
//
//        if(!sp.openPort()){
//            System.out.println("Puerto no disponible");
//        }
//        Scanner teclado = new Scanner(System.in);
//        // Configura un oyente para recibir datos del puerto serial
//        sp.addDataListener(new SerialPortDataListener() {
//            @Override
//            public int getListeningEvents() {
//                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
//            }
//
//            @Override
//            public void serialEvent(SerialPortEvent event) {
//                if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
//                    byte[] newData = new byte[sp.bytesAvailable()];
//                    int numRead = sp.readBytes(newData, newData.length);
//                    System.out.println("Datos recibidos: " + new String(newData, 0, numRead));
//                }
//            }
//        });
//
//        // Espera para recibir datos del Arduino
//        try {
//            Thread.sleep(2000); // Espera durante 10 segundos (ajusta el tiempo según tus necesidades)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
