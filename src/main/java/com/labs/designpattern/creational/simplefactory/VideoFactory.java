package com.labs.designpattern.creational.simplefactory;

/**
 * @author tanyun.zheng
 * @date 2022/8/2 20:52
 */
public class VideoFactory {
    private String type;
    private Class clazz;

    public VideoFactory(){
    }

    public VideoFactory(String type){
        this.type = type;
    }

    public Video getVideo(){
        if("Java".equalsIgnoreCase(type)){
            return new JavaVideo();
        }else if("Python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        return null;
    }

    public Video getVideo(Class clazz){
        Video video=null;
        try {
            video = (Video)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return video;
    }
}
