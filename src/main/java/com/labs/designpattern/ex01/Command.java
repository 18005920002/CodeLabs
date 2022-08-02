package com.labs.designpattern.ex01;

/**
 * ����ӿڣ��ýӿ�ͨ��undo����ʵ�ֳ�����
 *
 * @author win
 */
public interface Command {
    //ִ��
    public void execute();

    //����
    public void undo();
}