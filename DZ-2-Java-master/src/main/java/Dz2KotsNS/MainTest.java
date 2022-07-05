package Dz2KotsNS;

//Main класс для тестирования ДЗ
public class MainTest {
    public static void main(String[] args) {
        //Создаем объект Cat
        Cat objectCat1 = new Cat("kotik1", 10, 5);
        //запускаем метолд run()
        objectCat1.run();
        //запускаем метолд jump()
        objectCat1.jump();

        //Создаем объект Cat
        Cat objectCat2 = new Cat("kotik2", 7, 3);
        //запускаем метолд run()
        objectCat2.run();

        //Создаем объект Human
        Human objectHuman1 = new Human("chelovek1", 50, 1);

        //Создаем объект Human
        Human objectHuman2 = new Human("chelovek2", 30, 2);
        //запускаем метолд jump()
        objectHuman1.jump();

        //Создаем объект Robot
        Robot objectRobot1 = new Robot("Vova", 200, 7);

        //Создаем объект Robot
        Robot objectRobot2 = new Robot("Vova1", 15, 3);

        //Создаем объект Track
        Track objectTrack1 = new Track(40);

        objectTrack1.judge(objectCat1);
        objectTrack1.judge(objectHuman1);

        //Создаем объект Wall
        Wall objectWall1 = new Wall(2);
        objectWall1.judge(objectRobot1);

        //создаем массив из объектов Competitiors - Cat, Human, Robot
        Competitors[] massiv = {objectCat1, objectCat2, objectHuman1, objectHuman2, objectRobot1, objectRobot2};

        //создаем массив из объектов Obstacles - Track, Wall
        Obstacles[] massivPreptstv = {objectWall1, objectTrack1};

        //двумя циклами , один в другом, обходим все Obstacles из массива massivPrptstv и применяем judge() для каждого элемента в massiv.
        for (Obstacles ops : massivPreptstv) {
            for (Competitors com : massiv) {
                ops.judge(com);
            }
        }


    }
}
