package com.opm.opmservice.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/opm/ds")
@Tag(name = "DS Controller", description = "APIs for DS Controller")
public class DsController {

    @GetMapping("/demo")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok("Data");
    }

}
