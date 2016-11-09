package com.javarush.test.level30.lesson15.big01;

/**enum, который отвечает за тип сообщений пересылаемых между клиентом и сервером */
public enum MessageType
{
    NAME_REQUEST,
    USER_NAME,
    NAME_ACCEPTED,
    TEXT,
    USER_ADDED,
    USER_REMOVED
}
