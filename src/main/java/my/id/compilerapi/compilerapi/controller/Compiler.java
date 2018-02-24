package my.id.compilerapi.compilerapi.controller;
/*
    Created by : Rizki Maulana Akbar, On 02 - 2018 ;
*/

import my.id.compilerapi.compilerapi.service.JavaCompiler;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BlockingQueue;

@RestController
public class Compiler {

    @GetMapping("/")
    public String execute() throws InterruptedException {
        JavaCompiler javaCompiler = new JavaCompiler("Example.java");
        javaCompiler.run();
        return javaCompiler.getResult();
    }
}
