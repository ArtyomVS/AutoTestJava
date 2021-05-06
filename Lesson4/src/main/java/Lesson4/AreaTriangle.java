package Lesson4;


import static java.lang.Math.*;

public class AreaTriangle {
    public static void main(String[] args) {
        //Найдём периметр
        double perimeterTriangle = perimetrTriangle();
        System.out.println("Периметр треугольника = " + perimeterTriangle);
        //Найдём площадь
        double areaTriangle = sqrt(perimeterTriangle * (perimeterTriangle - numberOne()) * (perimeterTriangle - numberTwo()) * (perimeterTriangle - numberThree()));
        System.out.println("Площадь треугольника = " + areaTriangle);
        //Проверка на существование треугольника
        if (perimeterTriangle <= 0.0 | Double.isNaN(areaTriangle) | areaTriangle <= 0.0) {
            System.out.println("Проверьте длины сторон. При настоящих условиях треугольником и не пахнет! :)");
        }
        createTriangle(areaTriangle);
    }


    public static double perimetrTriangle(){
        double a = numberOne();
        double b = numberTwo();
        double c = numberThree();
        double perimeterTriangle = (a + b + c) / 2;
        return perimeterTriangle;
    }

    public static int numberThree() {
        int c = 20;
        return c;
    }

    public static int numberTwo() {
        int b = 15;
        return b;
    }

    public static int numberOne() {
        int a = 30;
        return a;
    }

    public static boolean createTriangle(double a){
        double areaTriangle = a;
        return a > 0;
    }
}
