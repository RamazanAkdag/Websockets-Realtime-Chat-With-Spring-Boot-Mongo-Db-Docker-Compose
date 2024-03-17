package com.ramazanfirat.iosmobileapi.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user")
    public User addUser(
        @Payload User user
    ){
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user")
    public User disconnect(
            @Payload User user
    ){
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/connectedUsers")
    public ResponseEntity<List<User>> findConnectedUsers(){

        return ResponseEntity.ok(userService.findConnectedUsers());
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

}