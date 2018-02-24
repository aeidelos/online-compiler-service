package my.id.compilerapi.compilerapi.service;
/*
    Created by : Rizki Maulana Akbar, On 02 - 2018 ;
*/

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Scanner;

public class JavaCompiler extends Compiler {

    public JavaCompiler (String filename) {
        super(filename);
    }

    @Override
    public void run() {
        this.compile();
        this.result = this.executor();
    }

    @Override
    public boolean compile() {
        try {
            this.process = runtime.exec(" javac "+this.root+this.filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String classname = this.filename.replace(".java",".class");
        File file = new File(classname);
        return file.isFile();
    }

    @Override
    public String executor() {
        String result = null;
            String classname = this.filename.replace(".java","");
            ProcessBuilder builder = new ProcessBuilder( "/bin/bash" );
            Process p=null;
            try {
                p = builder.start();
            }
            catch (IOException e) {
                System.out.println(e);
            }
            BufferedWriter p_stdin =
                    new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            try {
                p_stdin.write("cd code");
                p_stdin.newLine();
                p_stdin.flush();
            }
            catch (IOException e) {
                System.out.println(e);
            }

            try {
                //single execution
                p_stdin.write("java "+classname);
                p_stdin.newLine();
                p_stdin.flush();
            }
            catch (IOException e) {
                System.out.println(e);
            }
            try {
                p_stdin.write("exit");
                p_stdin.newLine();
                p_stdin.flush();
            }
            catch (IOException e) {
                System.out.println(e);
            }
            try {
                result = IOUtils.toString(p.getInputStream(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        return result;
    }
}
