package cathumanrobot;

public class Cat extends MembersNew {

    Cat(int height, int distance, String name){
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
