package wutest;

import java.util.List;

/**
 * Created by wushuai3 on 2017/2/6.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artits,List<String> tracks) {
        this.title = title;
        this.artist = artits;
        this.tracks = tracks;
    }

//    public BlankDisc() {
//    }

    @Override
    public void play() {
        System.out.println("Playing" + title + "by" + artist);
        for(String track:tracks){
            System.out.println("-Track:"+track);
        }

    }
}

