package com.wfm.wfmservice.Controller;

import com.wfm.wfmservice.DTO.WoConfigBusiness.WoConfigBusinessCUDto;
import com.wfm.wfmservice.DTO.WoConfigBusiness.WoConfigBusinessDeleteDto;
import com.wfm.wfmservice.Service.WoConfigBusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/wfm/wo-config-business")
public class WoConfigBusinessController {
    final WoConfigBusinessService woConfigBusinessService;

    public WoConfigBusinessController(WoConfigBusinessService woConfigBusinessService) {
        this.woConfigBusinessService = woConfigBusinessService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllWoConfigBusiness() {
        return woConfigBusinessService.getAllWoConfigBusiness();
    }

    @GetMapping("/get-wo-config-business")
    public ResponseEntity<Object> getWoConfigBusinessById(@RequestParam Long id) {
        return woConfigBusinessService.getWoConfigBusinessById(id);
    }

    @PostMapping("/create-wo-config-business")
    public ResponseEntity<Object> createWoConfigBusiness(@RequestBody WoConfigBusinessCUDto woConfigBusinessCUDto) {
        return woConfigBusinessService.createWoConfigBusiness(woConfigBusinessCUDto);
    }

    @PutMapping("/update-wo-config-business")
    public ResponseEntity<Object> updateWoConfigBusiness(@RequestBody WoConfigBusinessCUDto woConfigBusinessCUDto) {
        return woConfigBusinessService.updateWoConfigBusiness(woConfigBusinessCUDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteWoConfigBusiness
            (@RequestBody List<WoConfigBusinessDeleteDto> woConfigBusinessDeleteDtos) {
        return woConfigBusinessService.deleteWoConfigBusiness(woConfigBusinessDeleteDtos);
    }
}