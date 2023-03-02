package com.hox.userAuth.Controller;

import com.hox.userAuth.bean.userBean;
import com.hox.userAuth.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class userAuthController {

    @Autowired
    userService us = new userService();

    @GetMapping("/login")
    public ResponseEntity<String> logIn(String username, String password) throws InterruptedException,
            ExecutionException {
        return us.logIn(username, password);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody userBean usu) throws InterruptedException,
            ExecutionException {
        return us.signUp(usu.getUsername(), usu.getEmail(),
                usu.getPassword());
    }

    //------------------------------------------for functionality sanity check---------------------------------------//
    @GetMapping("/test")
    public ResponseEntity<String> testEndPoint(){
        return new ResponseEntity<>("Connect to port successfully", HttpStatus.OK);
    }

    @GetMapping("/getTest")
    public userBean getUserBean(@RequestParam String documentID) throws ExecutionException, InterruptedException {
        return us.getUser(documentID);
    }

    @PostMapping("/createTest")
    public String createUserBean(@RequestBody userBean ub) throws ExecutionException, InterruptedException {
        return us.createUser(ub);
    }

    @PutMapping("/updateTest")
    public String updateUserBean(@RequestBody userBean ub) throws ExecutionException, InterruptedException {
        return us.updateUser(ub);
    }

    @PutMapping("/deleteTest")
    public String deleteUserBean(@RequestParam String documentID){
        return us.deteleUser(documentID);
    }
}
