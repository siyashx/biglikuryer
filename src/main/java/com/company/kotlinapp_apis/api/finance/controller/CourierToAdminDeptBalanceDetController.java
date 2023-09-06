package com.company.kotlinapp_apis.api.finance.controller;

import com.company.kotlinapp_apis.dto.finance.CourierToAdminDeptBalanceDetDto;
import com.company.kotlinapp_apis.service.impl.finance.CourierToAdminDeptBalanceDetImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courierToAdminDeptBalanceDet")
public class CourierToAdminDeptBalanceDetController {

    private final CourierToAdminDeptBalanceDetImpl service;

    public CourierToAdminDeptBalanceDetController(CourierToAdminDeptBalanceDetImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CourierToAdminDeptBalanceDetDto>> getAllAdminToAdminDeptBalanceDet() {
        List<CourierToAdminDeptBalanceDetDto> all = service.getAllCourierToAdminDeptBalanceDets();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<CourierToAdminDeptBalanceDetDto> getAdminToAdminDeptBalanceDetById(@PathVariable("detId") Long id) {
        CourierToAdminDeptBalanceDetDto det = service.getCourierToAdminDeptBalanceDetById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CourierToAdminDeptBalanceDetDto> saveAdminToAdminDeptBalanceDet(@RequestBody CourierToAdminDeptBalanceDetDto dto) {
        CourierToAdminDeptBalanceDetDto created = service.saveCourierToAdminDeptBalanceDet(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteAdminToAdminDeptBalanceDet(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteCourierToAdminDeptBalanceDet(id);
        if (deleted) {
            return ResponseEntity.ok("AdminToAdminDeptBalanceDet deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
