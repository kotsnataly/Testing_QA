package Dz2KotsNS;

public class Robot implements Competitors {
    String name;
    int dlina;
    int height;

    //Это конструктор класса Robot
    public Robot(String name, int dlina, int height) {
        this.name = name;
        this.dlina = dlina;
        this.height = height;
    }

    //Это метод запуска бега.
    @Override
    public void run() {
        System.out.print(name + " is running ");
    }

    //Это метод запуска прыжка
    @Override
    public void jump() {
        System.out.print(name + " is jumping ");
    }

    //Это метод, получающий дальность забега
    @Override
    public int getDlina() {
        return dlina;
    }

    //Это метод, получающий высоту прыжка
    @Override
    public int getHeight() {
        return height;
    }

    //Это метод, получающий имя объекта
    public String getName() {
        return name;
    }
}
