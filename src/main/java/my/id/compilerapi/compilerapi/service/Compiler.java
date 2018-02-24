package my.id.compilerapi.compilerapi.service;
/*
    Created by : Rizki Maulana Akbar, On 02 - 2018 ;
*/

import lombok.Getter;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Compiler implements Runnable{

    protected String filename;
    protected Runtime runtime;
    protected Process process;
    protected BufferedReader bufferedReader;
    protected String root = "code/";
    @Getter
    protected String result = null;

    public Compiler(){}
    public Compiler(String filename) {
        this.filename = filename;
        this.runtime = Runtime.getRuntime();
    }

    @Override
    public abstract void run();

    public abstract boolean compile();

    public abstract String executor();

}
