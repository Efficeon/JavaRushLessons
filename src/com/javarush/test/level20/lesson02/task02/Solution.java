package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии
        // с путем к вашему реальному файлу
        try
        {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/home/lion/java/test/test1.txt");
            InputStream inputStream = new FileInputStream("/home/lion/java/test/test1.txt");
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.get(0).setBirthDate(new Date(Long.parseLong(String.valueOf(1481983))));
            javaRush.users.get(0).setCountry(User.Country.UKRAINE);
            javaRush.users.get(0).setFirstName("Leonid");
            javaRush.users.get(0).setLastName("Dubravsky");
            javaRush.users.get(0).setMale(true);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }
        public static class JavaRush
        {
            public List<User> users = new ArrayList<>();

            public void save(OutputStream outputStream) throws Exception
            {
                PrintWriter writer = new PrintWriter(outputStream);
                for (User user : users)
                {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(user.getBirthDate().getTime());
                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayedName());
                }
                writer.flush();
                writer.close();
            }

            public void load(InputStream inputStream) throws Exception
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                while (reader.ready())
                {
                    users.add(new User());
                    User user = users.get(users.size() - 1);
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date(Long.parseLong((reader.readLine()))));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    String country = reader.readLine();
                    if (country.equals("Ukraine"))  user.setCountry(User.Country.UKRAINE);
                    else if (country.equals("Russia"))   user.setCountry(User.Country.RUSSIA);
                    else user.setCountry(User.Country.OTHER);
                }
                reader.close();
            }
        }
    }

