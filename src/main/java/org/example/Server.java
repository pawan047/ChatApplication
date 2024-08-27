package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Server extends JFrame {
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    private JLabel heading=new JLabel("Server Area");
    private JTextField messageInput=new JTextField();
    private JTextArea messageArea=new JTextArea();
    private Font font=new Font("Roboto",Font.PLAIN,20);

    public Server() {
        try{
            server=new ServerSocket(7777);
            System.out.println("Server is read to accept connection");
            System.out.println("waiting..");
            socket=server.accept();
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());

            createGUI();
            handleEvent();
            startReading();
            //  startWriting();
        }catch(IOException e){

        }


    }
    private void handleEvent(){
        messageInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //  throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //  throw new UnsupportedOperationException("Not supported yet.");

                if(e.getKeyCode()==10){
                    // System.out.println("enter pressed "+e.getKeyCode());
                    String contentToSend=messageInput.getText();

                    messageArea.append("Me : "+contentToSend+"\n");
                    out.println(contentToSend);
                    out.flush();
                    messageInput.setText("");
                    messageInput.requestFocus();

                }

            }

        });
    }
    public void createGUI(){
        this.setTitle("Server Messager[END]");
        this.resize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        heading.setFont(font);
        messageInput.setFont(font);

        messageArea.setFont(font);
        messageArea.disable();
        messageArea.setBackground(Color.BLUE);
        heading.setIcon(new ImageIcon("chatIcon.png"));
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        messageInput.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(heading,BorderLayout.NORTH);
        this.add(messageArea,BorderLayout.CENTER);
        this.add(messageInput,BorderLayout.SOUTH);



        this.setVisible(true);


    }
    public void startReading(){
        Runnable r1;
        r1 = new Runnable() {
            @Override
            public void run() {


                System.out.println("reader started....");
                try{
                    while(true){

                        String  msg = br.readLine();

                        if(msg.equals("exit")){
                            System.out.println("Client terminated the chat");
                            socket.close();
                            break;
                        }
                        messageArea.append("Client: "+msg+"\n");
                    }


                }
                catch(IOException e){
                    System.out.println("connection is closed");
                }
            }
        };
        new Thread(r1).start();
    }
    public void startWriting(){
        Runnable r2=()->{
            System.out.println("Writer started...");

            try {
                while(!socket.isClosed()){


                    BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                    String content=br1.readLine();
                    if(content.equals("exit")){
                        System.out.println("Server terminated the chat");
                        socket.close();
                        break;
                    }
                    out.println(content);
                    out.flush();


                }
            }

            catch (IOException e) {
                System.out.println("connection is closed");

            }
        };
        new Thread(r2).start();

    }
    public static void main(String[] args) {
        System.out.println("This is a server class");
        Server s=new Server();
    }
}