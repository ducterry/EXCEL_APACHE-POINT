package com.ndangducbn.apachepoi.service;

import com.ndangducbn.apachepoi.model.Book;

import java.util.Arrays;
import java.util.List;

public class FakeData {
    public static List<Book> bookList = Arrays.asList(
            Book.builder().id(1001).price(10000D).quantity(100).title("Học vật lý 1").totalMoney(1000000D).build(),
            Book.builder().id(1002).price(10000D).quantity(100).title("Học vật lý 2").totalMoney(1000000D).build(),
            Book.builder().id(1003).price(10000D).quantity(100).title("Học vật lý 3").totalMoney(1000000D).build(),
            Book.builder().id(1004).price(10000D).quantity(100).title("Học vật lý 4").totalMoney(1000000D).build(),
            Book.builder().id(1005).price(10000D).quantity(100).title("Học vật lý 5").totalMoney(1000000D).build(),
            Book.builder().id(1006).price(10000D).quantity(100).title("Học vật lý 6").totalMoney(1000000D).build(),
            Book.builder().id(1007).price(10000D).quantity(100).title("Học vật lý 7").totalMoney(1000000D).build(),
            Book.builder().id(1008).price(10000D).quantity(100).title("Học vật lý 8").totalMoney(1000000D).build(),
            Book.builder().id(1009).price(10000D).quantity(100).title("Học vật lý 9").totalMoney(1000000D).build(),
            Book.builder().id(1010).price(10000D).quantity(100).title("Học vật lý 10").totalMoney(1000000D).build(),
            Book.builder().id(1011).price(10000D).quantity(100).title("Học vật lý 11").totalMoney(1000000D).build(),
            Book.builder().id(1012).price(10000D).quantity(100).title("Học vật lý 12").totalMoney(1000000D).build());
}
