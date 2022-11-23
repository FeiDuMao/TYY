package com.tyy.socket;

public interface WebSocketUseCase {

    void sendMessageToClient(String msg,String userName);

    void sendResultToClient(Object result,String userName);
}
