package Dz2KotsNS;

public class Cat implements Competitors {


    String name;
    int dlina;
    int height;
//Это конструктор класса Cat
    public Cat(String name, int dlina, int height) {
        this.name = name;
        this.dlina = dlina;
        this.height = height;
    }
//Это метод запуска бега.

    public void run() {
        System.out.print(name +" is running ");
    }
//Это метод запуска прыжка

    public void jump() {
        System.out.print(name +" is jumping ");
    }
    //Это метод, получающий дальность забега

    public int getDlina() {
        return dlina;
    }
//Это метод, получающий высоту прыжка

    public int getHeight() {
        return height;
    }

    //Это метод, получающий имя объекта
    public String getName() {
        return name;
    }

}
