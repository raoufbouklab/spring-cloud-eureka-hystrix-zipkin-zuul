package com.rbouklab.microdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBack(){
        return "UserService is taking longer than expected. Please try again later.";
    }

    @GetMapping("/libraryServiceFallBack")
    public String libraryServiceFallBack(){
        return "LibraryService is taking longer than expected. Please try again later.";
    }
}
