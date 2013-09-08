package org.guava.demo;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SupplierDemo {
    public static void main(String[] args) {
        final Supplier<Calendar> calendarSupplier = new Supplier<Calendar>() {
            @Override
            public Calendar get() {
                System.out.println("get...");
                return Calendar.getInstance();
            }
        };

        final Supplier<Calendar> calendarSupplierMemoized = Suppliers.memoize(calendarSupplier);

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println(simpleDateFormat.format(calendarSupplierMemoized.get().getTime()));
        System.out.println(simpleDateFormat.format(calendarSupplierMemoized.get().getTime()));
    }
}
