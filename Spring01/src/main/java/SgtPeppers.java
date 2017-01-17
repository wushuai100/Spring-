import org.springframework.stereotype.Component;

/**
 * Created by wushuai3 on 2017/1/17.
 */
@Component
public class SgtPeppers implements CompactDisc{
    private String title = "sssdsfdsfdsfsdfdfds";
    private String artist = "吴帅";
    @Override
    public void play() {
        System.out.println("Playing"+title+"by"+artist);

    }
}

