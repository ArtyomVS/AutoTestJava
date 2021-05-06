package org.example;


import Lesson4.AreaTriangle;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Lesson4.AreaTriangle.*;
import static org.junit.Assert.assertTrue;

public class AreaTriangleTest {
    AreaTriangle areaTriangle = new AreaTriangle();
    private static Logger logger = LoggerFactory.getLogger(AreaTriangle.class);



    @Test
    public void isPerimeterPositive(){
        double a = perimetrTriangle();
        assertTrue(a > 0);
        logger.info("Произошла проверка, что периметр треугольника больше нуля");
    }

    @Test
    public void isNumberOnePositive() {
        double a = numberOne();
        assertTrue(a > 0);
        logger.info("Произошла проверка, что первая сторона треугольника больше нуля");
    }

    @Test
    public void isNumberTwoPositive() {
        double a = numberTwo();
        assertTrue(a > 0);
        logger.info("Произошла проверка, что вторая сторона треугольника больше нуля");
    }

    @Test
    public void isNumberThreePositive() {
        double a = numberThree();
        assertTrue(a > 0);
        logger.info("Произошла проверка, что третья сторона треугольника больше нуля");
    }
    //Не работает следующий и ему подобный код. Ошибка: java: cannot access java.util.function.BooleanSupplier class file for java.util.function.BooleanSupplier not found
    @Test
    @DisplayName("Проверить функцию createTriangle положительным числом")
    void testIsNumberPositive() {
        Assertions.assertTrue(areaTriangle.createTriangle(1));
    }


}
