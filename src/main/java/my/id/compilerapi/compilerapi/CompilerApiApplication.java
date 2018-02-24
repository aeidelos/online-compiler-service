package my.id.compilerapi.compilerapi;

import my.id.compilerapi.compilerapi.service.Compiler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@SpringBootApplication
public class CompilerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompilerApiApplication.class, args);
	}
}
