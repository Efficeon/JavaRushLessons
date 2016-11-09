package com.javarush.test.level26.lesson15.big01;

public enum Operation
{
    INFO, DEPOSIT, WITHDRAW, EXIT, LOGIN;
/**Должен возвращать элемент энума: для 0 - LOGIN; 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT; */
    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        switch(i)
        {
            case 0: throw new IllegalArgumentException();
            case 1: return INFO;
            case 2: return DEPOSIT;
            case 3: return WITHDRAW;
            case 4: return EXIT;
            default: throw new IllegalArgumentException();
        }
    }
}
