package com.labs.designpattern.chain;

public interface Handler {
	void handleRequest(String number);
	void setNextHandler(Handler handler);
}
