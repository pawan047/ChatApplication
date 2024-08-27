package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Thread implements Runnable{
    public static  void Serverrunning() {

       Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                Server s=new Server();
            }
        });

        try {
            t1.start();
            t1.sleep(1000);

        } catch (Exception e) {
        }

    }
    public static void Clientrunning(){
        Thread t2=new Thread(new Runnable() {

            @Override
            public void run() {
                client c=new client();
            }
        });
        t2.start();
    }
    public static void main(String[] args) {
            Main.Serverrunning();
            Main.Clientrunning();

        }
}