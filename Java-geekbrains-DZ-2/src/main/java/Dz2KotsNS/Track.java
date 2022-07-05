package Dz2KotsNS;

public class Track implements Obstacles{
    int dlina;

    Track(int dlina){
        this.dlina = dlina;
    }

    public void judge(Competitors obj){
        if(obj.getDlina() < dlina){
            obj.run();
            System.out.println(obj.getName() + " failed");
        } else {
            obj.run();
            System.out.println(obj.getName() + " succeeded");
        }
    }
}
