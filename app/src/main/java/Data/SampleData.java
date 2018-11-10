package Data;

import java.util.ArrayList;
import java.util.List;

import Model.Item;
import Model.Music;

public class SampleData {
    public static List<Music> addSampleData(){
        List<Music> cs = new ArrayList<Music>();

        Music c1 = new Music();
        c1.setId((int) 1);
        c1.setName("playlist1");
        cs.add(c1);
        Music c2 = new Music();
        c2.setId((int) 2);
        c2.setName("playlist2");
        cs.add(c2);
        Music c3 = new Music();
        c3.setId((int) 3);
        c3.setName("playlist3");
        cs.add(c3);
        return cs;

}
}
