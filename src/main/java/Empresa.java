import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Empresa {
    private static int contador = 0;
    ReentrantLock lockEntrar = new ReentrantLock();
    ReentrantLock lockSalir = new ReentrantLock();
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void entra(Fan f) {
        lockEntrar.lock(); // Bloqueamos el método para que nadie lo pueda usar si hay un hilo usandolos
        Random random = new Random();
        try {
            // Entrar a la empresa (entre 5 y 10 segundos)
            Thread.sleep((random.nextInt(6) + 5) * 1000);
            System.out.println("El fan " + f.getNombre() + " ha entrado a la empresa.");
            contador++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockEntrar.unlock(); // Una vez que termine la ejecución del método, lo desbloqueamos.
        }
    }

    public void sale(Fan f) {
        lockSalir.lock(); // Bloqueamos el método para que nadie lo pueda usar si hay un hilo usandolos
        Random random = new Random();
        try {
            // Salir de la empresa (entre 5 y 10 segundos)
            Thread.sleep((random.nextInt(6) + 5) * 1000);
            System.out.println("El fan " + f.getNombre() + " ha salido de la empresa.");
            contador--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockSalir.unlock(); // Una vez que termine la ejecución del método, lo desbloqueamos.
        }
    }
}
