package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

/** класс, отвечающий за пересылаемые сообщения */
public class Message implements Serializable
{
    final private MessageType type;
    final private String data;

    public Message(MessageType type, String data)
    {
        this.type = type;
        this.data = data;
    }

    public Message(MessageType type)
    {
        this.type = type;
        data = null;

    }

    public MessageType getType()
    {
        return type;
    }

    public String getData()
    {
        return data;
    }


}
