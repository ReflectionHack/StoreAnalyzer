package edu.aubg.reflection.controller;

import edu.aubg.reflection.service.RestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroservicesController {

    private final RestService restService;

    public MicroservicesController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/prompt")
    public String prompt(@RequestBody String message) {
        return restService.promptBot(message);
    }

    @GetMapping("/message/{topic}")
    public String getMessage(@PathVariable String topic) {
        return restService.consumeMessage(topic);
    }
}
