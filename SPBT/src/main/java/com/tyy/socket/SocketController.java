package com.tyy.socket;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/socket")
@AllArgsConstructor
public class SocketController {
    private final WebSocketUseCase webSocketUseCase;


    @RequestMapping("/test")
    public String test() {
        webSocketUseCase.sendMessageToClient("ok","name");
        return "";
    }


}
