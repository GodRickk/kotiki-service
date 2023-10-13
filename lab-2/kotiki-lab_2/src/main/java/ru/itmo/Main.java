package ru.itmo;

import ru.itmo.dao.CatDao;
import ru.itmo.entity.Owner;
import ru.itmo.service.CatService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        CatService catService = new CatService(new CatDao());
        Calendar calendar = new GregorianCalendar(2000, 3, 25);
        Owner owner = new Owner("Ignat", calendar.getTime());
        System.out.println(owner.getBirthDate());
    }
}