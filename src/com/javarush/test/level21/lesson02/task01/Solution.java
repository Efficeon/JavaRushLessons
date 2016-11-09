package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, (byte)1, (byte)2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254,(byte) 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
       byte[] mass = {(byte)(mask[0]&ip[0]), (byte)(mask[1]&ip[1]), (byte)(mask[2]&ip[2]), (byte)(mask[3]&ip[3])};
       return mass;
   }

    public static void print(byte[] bytes) {
        for (int y = 0; y<4; y++){
            int value = bytes[y];
            StringBuilder result = new StringBuilder();
            for(int i = 1, j = 0; i < 256; i = i << 1, j++){
                result.append(((value & i) > 0 ? 1 : 0));
            }
            System.out.print(result.reverse());
            if (y<3)System.out.print(" ");
        }
        System.out.println();
    }
}
