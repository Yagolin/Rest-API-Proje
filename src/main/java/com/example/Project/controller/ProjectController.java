package com.example.Project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Content")
public class ProjectController {

    @GetMapping
    public static ResponseEntity<String> getUrlDatas(){

        StringBuilder datas = new StringBuilder();

        try
        {
            URL url_new = new URL("https://jsonplaceholder.typicode.com/");
            URLConnection connection_new = url_new.openConnection();
            
            BufferedReader reader_new = new BufferedReader(new InputStreamReader(connection_new.getInputStream()));
            String write_line;

            while((write_line = reader_new.readLine()) != null)
            {
                datas.append(write_line + "\n");
            }

            reader_new.close();

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        return new ResponseEntity<>(datas.toString(), HttpStatus.OK);
        
    }
}
