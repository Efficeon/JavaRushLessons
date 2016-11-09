package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "rek", "home", "same", "poeej", "fulm", "gsf", "rj",
                "rrj", "mglp", "jhvok", "orgn","ranm");
        if (list.size()!=0){
            for (Word x : list){
              System.out.print(x.text+" ");
              System.out.print(x.startX+" "+x.startY+" ");
              System.out.println(x.endX+" "+x.endY);
            }
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> listWords = new ArrayList<Word>();

        List<String> list = new ArrayList<String>();
        Collections.addAll(list, words);
        char[] word = null;
        boolean trueWord = false;

        //цикл по кождому слову
        for (String j : list){
            word =j.toCharArray();

            //ищем первую букву
            int x = 0;  int y=0;

            for (int i=0; i<crossword.length; i++){
                for (int f=0; f<crossword[i].length; f++){
                    if (word[0]==crossword[i][f]) {x=i; y=f;}
                    else continue;

                    //ищем допустимые направления
                    boolean left = false;
                    boolean right = false;
                    boolean up = false;
                    boolean down = false;
                    if (y-(word.length-1)>=0) left = true;
                    if (y+(word.length-1)<=crossword[i].length-1) right = true;
                    if (x-(word.length-1)>=0) up = true;
                    if (x+(word.length-1)<=crossword.length-1) down = true;

                    //проверяем направление left
                    if (left == true){
                        for (int le=y, gg=0; gg<word.length; gg++, le--){
                             if ((char)crossword[x][le]!=word[gg]) break;
                                trueWord = true;
                                if (gg == word.length-1){listWords.add(AddWords(y,x,le,x,j));
                    }}}
                    //проверяем направление right
                    if (right ==true){
                        for (int gg=0, d=y; gg<word.length; gg++, d++){
                             if ((char)crossword[x][d]!=word[gg])break;
                                trueWord = true;
                                if (gg==word.length-1) {listWords.add(AddWords(y,x,d,x,j));
                    }}}
                    //проверяем направление up
                    if (up == true){
                        for (int gg=0, u=x ; gg<word.length; gg++, u--){
                            if((char)crossword[u][y]!=word[gg])break;
                                trueWord = true;
                                if(gg==word.length-1) {listWords.add(AddWords(y,x,y,u,j));
                    }}}
                    //проверяем направление down;
                    if (down ==true){
                        for (int d=x, gg=0; gg<word.length; gg++,d++){
                            if((char)crossword[d][y]!=word[gg])break;
                                trueWord = true;
                                if(gg==word.length-1) {listWords.add(AddWords(y,x,y,d,j));
                    }}}
                    //проверяем направление leftUp
                    if (left && up ==true){
                        for (int d=x, r=y, gg=0; gg<word.length; gg++, d--, r--){
                            if((char)crossword[d][r]!=word[gg]) break;
                            trueWord = true;
                            if (gg==word.length-1) {listWords.add(AddWords(y,x,r,d,j));
                    }}}
                    //проверяем направление rightUp
                    if (right && up ==true){
                        for (int d=x, r=y, gg=0; gg<word.length; gg++, d--, r++){
                            if((char)crossword[d][r]!=word[gg]) break;
                            trueWord = true;
                            if (gg==word.length-1) {listWords.add(AddWords(y,x,r,d,j));
                    }}}
                    //проверяем направление leftDown
                    if (left && down ==true){
                        for (int d=x, r=y, gg=0; gg<word.length; gg++, d++, r--){
                            if((char)crossword[d][r]!=word[gg]) break;
                            trueWord = true;
                            if (gg==word.length-1) {listWords.add(AddWords(y,x,r,d,j));
                    }}}
                    //проверяем направление rightDown
                    if (right && down == true){
                        for (int d=x, r=y, gg=0; gg<word.length; gg++, d++, r++){
                            if((char)crossword[d][r]!=word[gg]) break;
                            trueWord = true;
                            if (gg==word.length-1) {listWords.add(AddWords(y,x,r,d,j));
                    }}}

                }  }  }
                return listWords;
    }
    
    public static Word AddWords(int startX, int startY, int endX, int endY, String word){
        Word answer = new Word(word);
        answer.text = word;
        answer.setStartPoint(startX,startY);
        answer.setEndPoint(endX,endY);
        return answer;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
