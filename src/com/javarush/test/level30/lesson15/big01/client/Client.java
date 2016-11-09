package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;


    /**должен запросить ввод адреса сервера у пользователя и вернуть введенное значение.*/
    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера: ");
        return ConsoleHelper.readString();
    }

    /**должен запрашивать ввод порта сервера и возвращать его.*/
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите номер порта сервера: ");
        return ConsoleHelper.readInt();
    }

    /**должен запрашивать и возвращать имя пользователя*/
    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }

    /**всегда должен возвращать true. Этот метод может быть переопределен, если мы будем писать какой-нибудь
     * другой клиент унаследованный от нашего, который не должен отправлять введенный в консоль текст.*/
    protected boolean shouldSentTextFromConsole(){
        return true;
    }

    /**должен создавать и возвращать новый объект класса SocketThread*/
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    /**создает текст. сообщение, используя переданный текст и отправляет его серверу через соединение connection.*/
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка! Отсутствует соединение с сервером.");
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this){
            this.wait();
            }
        }
        catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Возникла ошибка!");
            return;
        }
        if (clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        while (clientConnected){
            String text = ConsoleHelper.readString();
            if ("exit".equals(text)) break;
            if (shouldSentTextFromConsole()) sendTextMessage(text);
        }
    }

    public static void main(String[] args) {
        Client client=new Client();
        client.run();
    }

    /**Класс будет отвечать за поток, устанавливающий сокетное соединение и читающий сообщения сервера*/
    public class SocketThread extends Thread{

        /**должен выводить текст message в консоль*/
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        /**должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату */
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Уучастник с именем "+ userName +" присоединился к чату");
        }

        /**должен выводить в консоль, что участник с именем userName покинул чат*/
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник с именем "+ userName +" покинул чат");
        }

        /**Устанавливать значение поля clientConnected класса Client в соответствии с переданным параметром.
         * Оповещать (пробуждать ожидающий) основной поток класса Client.*/
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        /** этап рукопожатия (знакомства клиентом с сервера) */
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();

            switch (message.getType()){
                case NAME_REQUEST:
                     String name = getUserName();
                     connection.send(new Message(MessageType.USER_NAME, name));
                     break;
                case NAME_ACCEPTED:
                     notifyConnectionStatusChanged(true);
                     return;
                default:
                     throw new IOException("Unexpected MessageType");
                }
            }
        }

        /**метод, реализующий основной цикл обработки сообщений сервера.*/
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();

                switch (message.getType())
                {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }


        @Override
        public void run()
        {
            String serverNane = getServerAddress();
            int port = getServerPort();

            try
            {
                Socket socket = new Socket(serverNane, port);
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
