package com.daliy.gof.adapter;

/**
 * @author Lenovo
 * @date 2020/7/5 11:11
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        final AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3","一路向北");
        audioPlayer.play("mp4","青花瓷");
        audioPlayer.play("vlc","小青龙");
    }
}
