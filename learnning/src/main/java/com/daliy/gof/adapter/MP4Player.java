package com.daliy.gof.adapter;

/**
 * @author Lenovo
 * @date 2020/7/5 10:54
 */
public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
