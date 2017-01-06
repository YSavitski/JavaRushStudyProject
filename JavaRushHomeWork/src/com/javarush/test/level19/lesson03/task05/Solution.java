package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {

    private static Map<String,String> countries = new HashMap<String,String>();

    static{
        countries.put("UA", new Locale("", "UA").getDisplayCountry());
        countries.put("RU", new Locale("", "RU").getDisplayCountry());
        countries.put("CA", new Locale("", "CA").getDisplayCountry());
    }

    public static class DataAdapter implements RowItem{
        private Customer originalCustomer;
        private Contact originalContact;
        public DataAdapter(Customer customer, Contact contact) {
            this.originalContact = contact;
            this.originalCustomer = customer;
        }



        @Override
        public String getCountryCode()
        {
            String countryCode = null;
            for (Map.Entry<String, String> entry:
                 countries.entrySet())
            {
                if(entry.getValue().equals(originalCustomer.getCountryName())){
                    countryCode = entry.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany()
        {
            return originalCustomer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {

            return originalContact.getName().substring(originalContact.getName().indexOf(",")+2);
        }

        @Override
        public String getContactLastName()
        {
            return originalContact.getName().substring(0, originalContact.getName().indexOf(","));
        }

        @Override
        public String getDialString()
        {
            return originalContact.getPhoneNumber().replaceAll("[()-]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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