package com.javarush.test.level30.lesson15.big01;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/** класс соединения между клиентом и сервером */
public class Connection implements Closeable
{
    final private Socket socket;
    final private ObjectOutputStream out;
    final private ObjectInputStream in;


    public Connection(Socket socket) throws IOException
    {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    /**должен записывать (сериализовать) сообщение message в ObjectOutputStream.*/
    public void send(Message message) throws IOException{
        synchronized(out){
            out.writeObject(message);
        }
    }

    /**должен читать (десериализовать) данные из ObjectInputStream.*/
    public Message receive() throws IOException, ClassNotFoundException{
        synchronized(in){
        return (Message)in.readObject();
        }
    }

    /**возвращающий удаленный адрес сокетного соединения.*/
    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }

    /**должен закрывать все ресурсы класса.*/
    public void close() throws IOException{
        in.close();
        out.close();
        socket.close();
    }
}
