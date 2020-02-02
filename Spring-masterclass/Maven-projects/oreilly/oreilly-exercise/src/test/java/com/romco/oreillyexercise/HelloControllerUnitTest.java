package com.romco.oreillyexercise;

import com.romco.oreillyexercise.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerUnitTest {
    @Test
    void sayHello() {
        HelloController controller = new HelloController();
        Model model = new BindingAwareConcurrentModel();
        String result = controller.sayHello("world", model);
        assertEquals("hello", result);
        assertEquals("world", model.asMap().get("user"));
    }
}
