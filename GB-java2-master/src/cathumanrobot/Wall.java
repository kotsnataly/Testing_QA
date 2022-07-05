package cathumanrobot;

public class Wall implements Obstacles{

    int height;

    Wall(int height) {
        this.height = height;
    }
    public void test(MembersNew[] members) {
        for (int i = 0; i < members.length; i = i + 1){
            if (members[i].height < height) {
                System.out.println(members[i].name + " не смог перепрыгнуть");
            } else {
                System.out.println(members[i].name + " успешно перепрыгнул");
            }
        }
    }
}
