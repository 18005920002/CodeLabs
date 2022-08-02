package com.labs.designpattern.ex01;

/**
 * �ͻ���
 *
 * @author win
 */
public class RemoteLoader {
    public static void main(String[] args) {

        //����������
        RemoteControl rc = new RemoteControl();

        //����������
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo("Living Room");

        //��������
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        GarageDoorOpenCommand gdopen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorDownCommand gddown = new GarageDoorDownCommand(garageDoor);

        StereoOnWithCDCommand sowcdc = new StereoOnWithCDCommand(stereo);
        StereoOffCommand soc = new StereoOffCommand(stereo);


        //������
        rc.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        rc.setCommand(1, kitchenLightOn, kitchenLightOff);
        rc.setCommand(2, gdopen, gddown);
        rc.setCommand(3, sowcdc, soc);

        //�������������������ӡ����
        System.out.println(rc);

        rc.onButtonWasPushed(0);
        rc.offButtonWasPushed(0);
        rc.undoButtonWasPushed();
        System.out.println(rc);

        rc.onButtonWasPushed(1);
        rc.offButtonWasPushed(1);
        rc.onButtonWasPushed(2);
        rc.offButtonWasPushed(2);
        rc.onButtonWasPushed(3);
        rc.offButtonWasPushed(3);
    }
}
