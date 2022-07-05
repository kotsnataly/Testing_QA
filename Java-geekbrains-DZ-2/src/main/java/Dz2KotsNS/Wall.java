package Dz2KotsNS;

public class Wall implements Obstacles{
    int height;

    Wall(int height) {
        this.height = height;
    }

    public void judge(Competitors obj) {
        if (obj.getHeight() < height) {
            obj.jump();
            System.out.println(obj.getName() + " failed");
        } else {
            obj.jump();
            System.out.println(obj.getName() + " succeeded");

        }
    }
}
