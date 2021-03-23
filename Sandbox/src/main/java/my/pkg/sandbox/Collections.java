package my.pkg.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args){
       String[] langs = {"Java", "C#", "Python", "PHP"}; //Статический массив. Индексы в [], длина - len

       List<String> languages = Arrays.asList(langs); //Список - динамический массив.  массив.get(индекс), длина массив.size


       for (String l : languages){
           System.out.println("Я хочу выучить " + l);
       }

    }
}
