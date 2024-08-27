package Homework_lesson9;

public class HomeWorkLesson9 {
    public static void main(String[] args) {
        //Task1
        taskCompany();

        //Task2
        taskFigure();

        //Task *
        taskClonable();

    }

    private static void taskClonable() {
        TestClone test = new TestClone("test", "description", 12);
        try {
            TestClone testClone = test.clone();
            System.out.println("Object: "+test);
            System.out.println("Clone: " + testClone);

            testClone.setDescription("clone description");
            testClone.setName("clone name");
            testClone.setSomeValue(20);

            System.out.println("Object: "+test);
            System.out.println("Clone: " + testClone);


        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void taskFigure() {
        Figure[] figures = {
                new Circle(10),
                new Triangle(10, 4, 5),
                new Rectangle(10, 16),
                new Rectangle(3, 6),
                new Triangle(12, 6, 7),
                new Circle(30)
        };
        double result = 0;
        for (Figure figure : figures) {
            result += figure.getPerimeter();
        }
        System.out.println("The sum of the perimeters of figures: " + result);
    }

    private static void taskCompany() {
        Worker worker = new Worker("Fedor");
        Director director = new Director("Ivan");
        Accountant accountant = new Accountant("Irina");

        worker.printPosition();
        director.printPosition();
        accountant.printPosition();
    }
}
