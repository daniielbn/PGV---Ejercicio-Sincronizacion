import java.util.Random;

public class Fan implements Runnable{
    private String nombre;
    private Empresa empresa;

    public Fan(String nombre, Empresa empresa) {
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public synchronized void llegar() {
        Random random = new Random();
        try {
            // Llegar a la empresa (entre 1 y 10 segundos)
            Thread.sleep((random.nextInt(10) + 1) * 1000);
            System.out.println("El fan " + nombre + " ha llegado a la empresa.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void quejarse() {
        Random random = new Random();
        try {
            // Quejarse (entre 5 y 15 segundos)
            Thread.sleep((random.nextInt(11) + 5) * 1000);
            System.out.println("El fan " + nombre + " se ha quejado.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        llegar();

        empresa.entra(this);
        System.out.println("El contador de la empresa es: " + empresa.getContador());

        quejarse();

        empresa.sale(this);
        System.out.println("El contador de la empresa es: " + empresa.getContador());
    }
}
