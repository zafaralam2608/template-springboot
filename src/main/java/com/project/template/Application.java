package com.project.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class.
 */
@SpringBootApplication
public class Application {

  private Application() {
    // Utility class
  }

  /**
   * The main method of the application.
   *
   * @param args the runtime arguments
   */
  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
