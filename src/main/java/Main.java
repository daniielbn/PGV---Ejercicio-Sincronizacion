import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Fan fan1 = new Fan("Fan 1", empresa);
        Fan fan2 = new Fan("Fan 2", empresa);
        Fan fan3 = new Fan("Fan 3", empresa);
        Fan fan4 = new Fan("Fan 4", empresa);
        Fan fan5 = new Fan("Fan 5", empresa);
        Fan fan6 = new Fan("Fan 6", empresa);
        Fan fan7 = new Fan("Fan 7", empresa);
        Fan fan8 = new Fan("Fan 8", empresa);
        Fan fan9 = new Fan("Fan 9", empresa);
        Fan fan10 = new Fan("Fan 10", empresa);

        try {
            Thread hilo1 = new Thread(fan1);
            Thread hilo2 = new Thread(fan2);
            Thread hilo3 = new Thread(fan3);
            Thread hilo4 = new Thread(fan4);
            Thread hilo5 = new Thread(fan5);
            Thread hilo6 = new Thread(fan6);
            Thread hilo7 = new Thread(fan7);
            Thread hilo8 = new Thread(fan8);
            Thread hilo9 = new Thread(fan9);
            Thread hilo10 = new Thread(fan10);

            hilo1.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();
            hilo5.start();
            hilo6.start();
            hilo7.start();
            hilo8.start();
            hilo9.start();
            hilo10.start();

            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
            hilo6.join();
            hilo7.join();
            hilo8.join();
            hilo9.join();
            hilo10.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
