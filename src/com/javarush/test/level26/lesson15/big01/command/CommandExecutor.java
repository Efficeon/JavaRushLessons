package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

/**класс CommandExecutor, через который можно будет взаимодействовать со всеми командами.*/
public final class CommandExecutor {

    /**Создадим статическую карту Map<Operation, Command>, которую проинициализируем
     * всеми известными нам операциями и командами.*/
    private static Map<Operation, Command> map = new HashMap<>();
    static {
        map.put(Operation.LOGIN, new LoginCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }

    /**будет дергать метод execute у нужной команды.*/
    public static final void execute(Operation operation) throws InterruptOperationException, NotEnoughMoneyException
    {
        map.get(operation).execute();
    }

    private CommandExecutor()
    {
    }
}
