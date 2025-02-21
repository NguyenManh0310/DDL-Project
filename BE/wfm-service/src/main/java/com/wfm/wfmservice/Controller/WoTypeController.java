package com.wfm.wfmservice.Controller;

import com.wfm.wfmservice.DTO.WoType.WoTypeCUDto;
import com.wfm.wfmservice.DTO.WoType.WoTypeDeleteDto;
import com.wfm.wfmservice.DTO.WoType.WoTypeDetailDto;
import com.wfm.wfmservice.Service.WoTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/wfm/wo-type")

public class WoTypeController {
    final WoTypeService woTypeService;

    public WoTypeController(WoTypeService woTypeService) {
        this.woTypeService = woTypeService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllWoType() {

        return  woTypeService.getAllWoType();
    }

    @GetMapping("/get-wo-type")
    public ResponseEntity<Object> getWoTypeById(@RequestParam Long id) {
        return woTypeService.getWoTypeById(id);
    }

    @PostMapping("/create-wo-type")
    public ResponseEntity<Object> createWoType(@RequestBody WoTypeCUDto woTypeCUDto) {
        return woTypeService.createWoType(woTypeCUDto);
    }

    @PutMapping("/update-wo-type")
    public ResponseEntity<Object> updateWoType(@RequestBody WoTypeCUDto woTypeCUDto) {
        return woTypeService.updateWoType(woTypeCUDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteWoType(@RequestBody List<WoTypeDeleteDto> woTypeDeleteDtos) {
        return woTypeService.deleteWoType(woTypeDeleteDtos);
    }
}
