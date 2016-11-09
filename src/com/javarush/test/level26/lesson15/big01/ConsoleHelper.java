package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Т.к мы будем активно общаться с юзером, то будет много выводимого текста.
Чтобы работу с консолью сосредоточить в одном месте, создадим класс ConsoleHelper*/

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    /**будет писать в консоль наше сообщение*/
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
    /**будет считывать с консоли строку и возвращать ее.*/
    public static String readString() throws InterruptOperationException
    {
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line.equalsIgnoreCase(res.getString("operation.EXIT"))) throw new InterruptOperationException();

                return line;

            }
            catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**Чтобы считать код валюты. Этот метод должен предлагать пользователю ввести код валюты, проверять,
     что код содержит 3 символа. Если данные некорректны, то сообщить об этом пользователю и повторить.
     Если данные валидны, то перевести код в верхний регистр и вернуть.*/
    public static String askCurrencyCode() throws InterruptOperationException
    {
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String str = readString();
            if (str.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            } else {
                return str.toUpperCase();
            }
        }
    }

    /**Чтобы считать номинал и количество банкнот. Этот метод должен предлагать пользователю ввести два целых
     * положительных числа. Первое число - номинал, второе - количество банкнот.*/
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String userInput = readString();
            String[] strmas = userInput.split(" ");
            try {
                if (strmas.length == 2 && Integer.parseInt(strmas[0]) >= 0 && Integer.parseInt(strmas[1]) >= 0) {
                    return strmas;
                } else {
                    writeMessage(res.getString("invalid.data"));
                }
            }catch (NumberFormatException ex) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    /**Спросить у пользователя операцию.
    * Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
    * Используйте метод, описанный в п.1.*/
    public static Operation askOperation() throws InterruptOperationException
    {
        while (true) {
            writeMessage("Выберите операцию (1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT): ");
            String operation = readString();
            while (true){
                if (checkWithRegExp(operation)){
                    return Operation.getAllowableOperationByOrdinal(Integer.parseInt(operation));
                }
                else writeMessage(res.getString("invalid.data"));
                break;
            }
        }
    }

    public static boolean checkWithRegExp(String Name) {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }
}