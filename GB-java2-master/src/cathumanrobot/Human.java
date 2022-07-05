package cathumanrobot;

public class Human extends MembersNew  {

    Human(int height, int distance, String name){
        this.height = height;
        this.distance = distance;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " бежит");
    }

    @Override
    public void jump() {
        System.out.println(this.name + " прыгает");
    }
}
