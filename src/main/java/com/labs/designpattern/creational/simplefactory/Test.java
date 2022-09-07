package com.labs.designpattern.creational.simplefactory;

/**
 * @author tanyun.zheng
 * @date 2022/8/2 20:52
 */
public class Test {
    public static void main(String[] args) {
        /*Video video = new VideoFactory("python").getVideo();
        video.produce();*/
        Video video = new VideoFactory().getVideo(PythonVideo .class);
        video.produce();
    }
}
