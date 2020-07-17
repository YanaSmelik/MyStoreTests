package com.mystore.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig(){

        Path sourcePath = Paths.get("Configuratin/config.properties");

        try{
            InputStream inputStream = Files.newInputStream(sourcePath);
            properties = new Properties();
            properties.load(inputStream);

        }catch (Exception e){
            System.out.println("Exception is: " + e.getMessage());
        }
    }
}
