package com.company.kotlinapp_apis.api.finance.controller;

import com.company.kotlinapp_apis.dto.finance.CourierYourDeptBalanceDetDto;
import com.company.kotlinapp_apis.service.impl.finance.CourierYourDeptBalanceDetImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courierYourDeptBalanceDets")
public class CourierYourDeptBalanceDetController {

    private final CourierYourDeptBalanceDetImpl service;

    public CourierYourDeptBalanceDetController(CourierYourDeptBalanceDetImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CourierYourDeptBalanceDetDto>> getAllCourierYourDeptBalanceDet() {
        List<CourierYourDeptBalanceDetDto> all = service.getAllCourierYourDeptBalanceDets();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<CourierYourDeptBalanceDetDto> getCourierYourDeptBalanceDetById(@PathVariable("detId") Long id) {
        CourierYourDeptBalanceDetDto det = service.getCourierYourDeptBalanceDetById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CourierYourDeptBalanceDetDto> saveCourierYourDeptBalanceDet(@RequestBody CourierYourDeptBalanceDetDto dto) {
        CourierYourDeptBalanceDetDto created = service.saveCourierYourDeptBalanceDet(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteCourierYourDeptBalanceDet(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteCourierYourDeptBalanceDet(id);
        if (deleted) {
            return ResponseEntity.ok("CourierYourDeptBalanceDet deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
