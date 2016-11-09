package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    @Override
    public void execute() throws InterruptOperationException
    {
        String cardEntered;
        String pinEntered;

        ConsoleHelper.writeMessage(res.getString("before"));
        while(true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            cardEntered = ConsoleHelper.readString();
            pinEntered = ConsoleHelper.readString();
            if (validCreditCards.containsKey(cardEntered)){
               if (validCreditCards.getString(cardEntered).equals(pinEntered)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardEntered));
                    break;
                } else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardEntered));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
            }
            else ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
        }
    }
}
