package com.ssafy.day4.d_object;

public class ProductTest {

    public static void main(String[] args) {
        Product product1 = new Product("123");
        Product product2 = new Product("123");

        System.out.println(product1);
        System.out.println(product1.equals(product2));
        System.out.printf("hashCode: %d, %d\n", product1.hashCode(), product2.hashCode());
    }
}
