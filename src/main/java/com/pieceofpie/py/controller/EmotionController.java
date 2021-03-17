package com.pieceofpie.py.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("emotion")
public class EmotionController {

    @RequestMapping("start")
    public void start(){
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("C:\\Users\\asus\\Desktop\\pythonProject1\\test.bat");// 执行py文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("quit")
    public void quit(){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("quit.txt"));
            out.write("q");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
