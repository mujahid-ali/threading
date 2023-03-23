

class Runner extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }    
    }
}


public class App {
    public static void main(String[] args) {

        Runner thread1 = new Runner();
        Runner thread2 = new Runner();

        thread1.start();
        thread2.start();
        
    }
}