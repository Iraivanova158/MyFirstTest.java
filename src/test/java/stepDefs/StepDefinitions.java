package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.ru.Дано;

public class StepDefinitions {
    @Дано("надпись Hello world")
    public void print_hello_world(){
        System.out.println("Hello, world!");

    }
}
