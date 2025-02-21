package com.wfm.wfmservice.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/api/wfm/wo")
@Tag(name = "WO Controller", description = "APIs for WO Controller")
public class WoController {
    @GetMapping("/demo")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok("Data");
    }

}