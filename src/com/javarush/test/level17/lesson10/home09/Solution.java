package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader0 = new BufferedReader(new InputStreamReader(System.in));
            FileReader reader = new FileReader(new File(reader0.readLine()));
            FileReader reader1 = new FileReader(new File(reader0.readLine()));
            BufferedReader bufferedReader = new BufferedReader(reader);
            BufferedReader bufferedReader1 = new BufferedReader(reader1);

            String line = bufferedReader.readLine();
            while (line != null)
            {
                allLines.add(line);
                line = bufferedReader.readLine();
            }

            line = bufferedReader1.readLine();
            while (line != null)
            {
                forRemoveLines.add(line);
                line = bufferedReader1.readLine();
            }

            Solution solution = new Solution();
            solution.joinData();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public void joinData() throws CorruptedDataException
    {


        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        } else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
