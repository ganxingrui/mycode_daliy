package com.daliy.gof.adapter;

/**
 * @author Lenovo
 * @date 2020/7/5 10:57
 */
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new MP4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equals(audioType)){
            advancedMediaPlayer.playVlc(fileName);
        }else if ("mp4".equals(audioType)){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
