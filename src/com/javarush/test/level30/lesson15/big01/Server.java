package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** основной класс сервера */

public class Server
{
    /** ключом будет имя клиента, а значением - соединение с ним.*/
    final private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        for (String name : connectionMap.keySet()){
            try
            {
                connectionMap.get(name).send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Не могу отправить сообщение клиенту с именем: " + name);
            }
        }
    }

    public static void main(String args[]){

        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();

        try(ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Сервер запущен на порту: " + port);
            while (true){
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }


    private static class Handler extends Thread
    {
        private Socket socket;

        private Handler(Socket socket)
        {
            this.socket = socket;
        }

        /** этап рукопожатия (знакомства сервера с клиентом) */
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {

            String name = null;

            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME)
                {
                    name = message.getData();
                    if (!name.isEmpty() && connectionMap.get(name) == null)
                    {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }
            return name;
        }


        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {

            for (String name : connectionMap.keySet())
            {
                if (!name.equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException
        {

            while (!Thread.currentThread().isInterrupted())
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    String messageText = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, messageText));
                } else
                {
                    ConsoleHelper.writeMessage(String.format("Ошибка! Недопустимый тип сообщения (MessageType.%s) "
                            + "от клиента: %s", message.getType().toString(), userName));
                }
            }
        }

        @Override
        public void run() {
            //Task 11.1
            ConsoleHelper.writeMessage("Установлено соединение с удаленным клиентом с адресом: " +
                    socket.getRemoteSocketAddress());

            //Task 11.2
            Connection connection = null;
            String clientName = null;
            try {
                connection = new Connection(socket);

                //Task 11.3
                clientName = serverHandshake(connection);
                //Task 11.4
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));

                //Task 11.5
                sendListOfUsers(connection, clientName);
                //Task 11.6
                serverMainLoop(connection, clientName);

            } catch (IOException e) {
                handleHandlerException(e, connection);
            } catch (ClassNotFoundException e) {
                handleHandlerException(e, connection);
            }
            // disconnecting client
            if (clientName != null) {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }

            ConsoleHelper.writeMessage(String.format("Соединение с удаленным адресом (%s) закрыто.", socket.getRemoteSocketAddress()));
        }

        private void handleHandlerException(Exception e, Connection connection) {
            ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом: " +
                    socket.getRemoteSocketAddress() + "%n" +
                    "Тип ошибки: " + e.getClass().getSimpleName() + "%n" +
                    "Текст ошибки: " + e.getMessage());
            try {
                if (connection != null)
                    connection.close();
                socket.close();
            } catch (IOException e_) { /* NOP */ }
        }
    }

}
