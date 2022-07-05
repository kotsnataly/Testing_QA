package cathumanrobot;

public class Main {
    public static void main(String[] args) {
        MembersNew kotik1 = new Cat(20, 10, "Barsik");
        MembersNew kotik2 = new Cat(10, 30, "Murzik");
        MembersNew human1 = new Human(20, 40, "Nata");
        MembersNew human2 = new Human(30, 30, "Vova");
        MembersNew robot1 = new Robot(50, 20, "Chappi");
        MembersNew robot2 = new Robot(10, 50, "Bender");

        kotik1.jump();
        kotik2.run();
        human1.run();
        human1.jump();
        robot1.jump();

        MembersNew[] competitors = {kotik1, kotik2, human1, human2, robot1, robot2};
        Track track1 = new Track(20);
        Wall wall1 = new Wall(30);
        track1.test(competitors);
        wall1.test(competitors);
    }
}
