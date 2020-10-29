package main;
import classes.Mreview;
import classes.Cat;
import classes.Dog;

public class TestMain {
    public static void main(String[] args) {
        // Part A
        Mreview psycho = new Mreview("Psycho");
        psycho.addRating(10);
        psycho.addRating(10);
        psycho.addRating(9);
        System.out.println(psycho);
        System.out.println(psycho.aveRating());

        System.out.println("==================");
        // Part C
        final int MALE = 0;
        final int FEMALE = 1;
        final int SPAYED = 2;
        final int NEUTERED = 3;
        final int BAD_GENDER_ID = 4;
        Cat cat = new Cat("Tom", "Bob", "black", "short");
        cat.setSex(BAD_GENDER_ID);
        System.out.println("Printing bad gender id: " + cat.getSex());
        cat.setSex(SPAYED);
        System.out.println(cat.getSex());
        System.out.println();

        System.out.println(cat);
        System.out.println();

        cat.setBoardStart(1, 1, 2020);
        cat.setBoardEnd(12, 31, 2020);
        System.out.println("Returns TRUE when boarding date is 01/01/2020: " + cat.boarding(01, 01, 2020));
        System.out.println("Returns TRUE when boarding date is 12/31/2020: " + cat.boarding(12, 31, 2020));
        System.out.println("Returns FALSE when boarding date is 01/01/2019: " + cat.boarding(01, 01, 2019));
        System.out.println("Returns FALSE when boarding date is 12/31/2020: " + cat.boarding(12, 31, 2021));
        System.out.println();

        Dog dog = new Dog("Spot", "Susan", "white", "medium");
        dog.setSex(BAD_GENDER_ID);
        System.out.println("Printing bad gender id: " + dog.getSex());
        dog.setSex(SPAYED);
        System.out.println(dog.getSex());
        System.out.println();

        System.out.println(dog);
        System.out.println();

        dog.setBoardStart(1, 1, 2020);
        dog.setBoardEnd(12, 31, 2020);
        System.out.println("Returns TRUE when boarding date is 01/01/2020: " + dog.boarding(01, 01, 2020));
        System.out.println("Returns TRUE when boarding date is 12/31/2020: " + dog.boarding(12, 31, 2020));
        System.out.println("Returns FALSE when boarding date is 01/01/2019: " + dog.boarding(01, 01, 2019));
        System.out.println("Returns FALSE when boarding date is 12/31/2020: " + dog.boarding(12, 31, 2021));
        System.out.println();

    }
}
