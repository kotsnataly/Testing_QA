package cathumanrobot;

public class Track implements Obstacles {

        int distance;

    Track(int distance){
        this.distance = distance;
    }

    public void test(MembersNew[] members) {
        for (int i = 0; i < members.length; i = i + 1){
            if (members[i].distance < distance) {
                System.out.println(members[i].name + " не смог пробежать");
            } else {
                System.out.println(members[i].name + " успешно пробежал");
            }
        }
    }
}
