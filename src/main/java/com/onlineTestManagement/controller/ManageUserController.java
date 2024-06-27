//package com.onlineTestManagement.controller;
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("")
//public class ManageUserController {
//    @GetMapping("/user")
//    public String welcome() throws IOException {
//        Resource resource = new ClassPathResource("static/index.html");
//        String content = Files.lines(Paths.get(resource.getURI())).collect(Collectors.joining("\n"));
//        return content;
//    }
//}
