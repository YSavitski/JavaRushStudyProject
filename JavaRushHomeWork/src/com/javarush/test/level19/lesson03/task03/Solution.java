package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static{
        countries.put("UA", new Locale("", "UA").getDisplayCountry());
        countries.put("RU", new Locale("", "RU").getDisplayCountry());
        countries.put("CA", new Locale("", "CA").getDisplayCountry());
    }


    public static class IncomeDataAdapter implements Customer, Contact{

        private IncomeData incomeDataComponent;
        public IncomeDataAdapter(IncomeData component){
            this.incomeDataComponent = component;
        }

        private String CustomizePhoneNumber(String code, String phone){

            String resultPhone = "";
            if(phone.length() < 10){
                for(int i=0; i<(10-phone.length()); i++){
                    resultPhone += "0";
                }
            }
            resultPhone += phone;

            System.out.println(resultPhone);
            return "+" + code + "(" + resultPhone.substring(0, 3) + ")" + resultPhone.substring(3, 6) + "-" + resultPhone.substring(6,8)+ "-" + resultPhone.substring(8);
        }

        @Override
        public String getCompanyName()
        {
            return incomeDataComponent.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(incomeDataComponent.getCountryCode());
        }

        @Override
        public String getName()
        {
            return incomeDataComponent.getContactLastName() + ", " + incomeDataComponent.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            return CustomizePhoneNumber(Integer.toString(incomeDataComponent.getCountryPhoneCode()), Integer.toString(incomeDataComponent.getPhoneNumber()));
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}