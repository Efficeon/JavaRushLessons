package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;

/**класс Controller, в нем будет содержаться бизнес логика*/
public class Controller
{
    private Model model;

    public Controller(Model model)
    {
       this.model = model;
        if (model ==null) throw new IllegalArgumentException("Illegal arguments");
    }

    public void onCitySelect(String cityName){
        this.model.selectCity(cityName);
    }
}
