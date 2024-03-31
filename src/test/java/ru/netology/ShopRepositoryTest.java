package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ShopRepositoryTest {

    @Test
    public void shouldAddThreeProduct() {
        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(2, "Футболка", 550);
        Product product3 = new Product(3, "Футболка", 600);

        ShopRepository shop = new ShopRepository();

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdMin() {
        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(2, "Футболка", 550);
        Product product3 = new Product(3, "Футболка", 600);

        ShopRepository shop = new ShopRepository();

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Product expected = product1;
        Product actual = shop.findById(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdMax() {
        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(2, "Футболка", 550);
        Product product3 = new Product(3, "Футболка", 600);

        ShopRepository shop = new ShopRepository();

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Product expected = product3;
        Product actual = shop.findById(3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdMax() {
        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(2, "Футболка", 550);
        Product product3 = new Product(3, "Футболка", 600);

        ShopRepository shop = new ShopRepository();

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.removeById(3);
        Product[] expected = {product1, product2};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundByIdMin() {
        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(2, "Футболка", 550);
        Product product3 = new Product(3, "Футболка", 600);

        ShopRepository shop = new ShopRepository();

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
    shop.removeById(1);
        Product[] expected = {product2, product3};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundByIdUnderMin() {
        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(2, "Футболка", 550);
        Product product3 = new Product(3, "Футболка", 600);

        ShopRepository shop = new ShopRepository();

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeById(0);
        });
    }

    @Test
    public void shouldNotFoundByIdAboveMax() {
        Product product1 = new Product(1, "Футболка", 500);
        Product product2 = new Product(2, "Футболка", 550);
        Product product3 = new Product(3, "Футболка", 600);

        ShopRepository shop = new ShopRepository();

        shop.add(product1);
        shop.add(product2);
        shop.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeById(4);
        });
    }
//    @Test
//    public void shouldFoundByIdAlready() {
//        Product product1 = new Product(1, "Футболка", 500);
//        Product product2 = new Product(2, "Футболка", 550);
//        Product product3 = new Product(3, "Футболка", 600);
//
//        ShopRepository shop = new ShopRepository();
//
//        shop.add(product1);
//        shop.add(product2);
//        shop.add(product3);
//
//        Assertions.assertThrows(AlreadyExistsException.class, () -> {
//            shop.add(product3);
//        });
//    }

}

