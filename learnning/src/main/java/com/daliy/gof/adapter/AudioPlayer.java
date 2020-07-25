package com.daliy.gof.adapter;

/**
 * @author Lenovo
 * @date 2020/7/5 11:01
 */
public class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equals(audioType)){
            System.out.println("Palying mp3 file Name:" + fileName);
        }else if ("vlc".equals(audioType) || "mp4".equals(audioType)){
            final MediaAdapter mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }else {
            System.out.println("not suppport");
        }
    }
}
