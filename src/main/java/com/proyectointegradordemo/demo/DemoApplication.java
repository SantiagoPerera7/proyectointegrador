package com.proyectointegradordemo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.proyectointegradordemo.iu.VentanaInicio;
import java.awt.GraphicsEnvironment;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
                System.setProperty("java.awt.headless", "false");
		SpringApplication.run(DemoApplication.class, args);
                //VentanaInicio v = new VentanaInicio();
                //v.setVisible(true);
	}
    }
