package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    Solution()
    {
    }

    Solution(byte x)
    {
    }

    Solution(Byte x)
    {
    }

    public Solution(String x)
    {
    }

    public Solution(Integer x)
    {
    }

    public Solution(int x)
    {
    }

    private Solution(Double x)
    {
    }

    private Solution(Short x)
    {
    }

    private Solution(short x)
    {
    }

    protected Solution(char x)
    {
    }

    protected Solution(Character x)
    {
    }

    protected Solution(long x)
    {
    }


}

