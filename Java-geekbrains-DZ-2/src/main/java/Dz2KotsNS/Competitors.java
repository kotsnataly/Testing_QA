package Dz2KotsNS;
//Это интерфейс для всех участников соревнования Human, Cat, Robot
public interface Competitors {


    void run();

    void jump();

    int getDlina();

    int getHeight();

    public String getName();
}
