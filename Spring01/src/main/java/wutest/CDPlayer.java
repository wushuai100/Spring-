package wutest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wushuai3 on 2017/1/19.
 */
public class CDPlayer implements MediaPlayer{
    private CompactDisc cd;
    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }



    @Override
    public void paly() {
        cd.play();
    }
}
