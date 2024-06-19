package com.example.alura.screensounds;

import com.example.alura.screensounds.main.Main;
import com.example.alura.screensounds.repository.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundsApplication implements CommandLineRunner {

	private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.mainMenu();
	}
}
