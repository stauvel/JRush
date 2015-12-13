package org.jrush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

/**
 * Created by Seb on 18/11/2015.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        URL[] urls = new URL[args.length];
        for (int i = 0; i < args.length; i++) {
            String url = args[i]; //"file:///home/me/spi-addon-1.0.jar"
            urls[i] = new URL(url);
        }
        //ExerciceServiceLoader.extensionClassLoader = new URLClassLoader(urls, Application.class.getClassLoader());
        SpringApplication.run(Application.class, args);
    }
}