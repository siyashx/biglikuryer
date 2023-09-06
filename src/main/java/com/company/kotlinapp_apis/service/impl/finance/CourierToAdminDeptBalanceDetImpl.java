package com.company.kotlinapp_apis.service.impl.finance;

import com.company.kotlinapp_apis.dao.finance.CourierToAdminDeptBalanceDetRepository;
import com.company.kotlinapp_apis.dto.finance.CourierToAdminDeptBalanceDetDto;
import com.company.kotlinapp_apis.model.finance.CourierToAdminDeptBalanceDet;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierToAdminDeptBalanceDetImpl {

    private final CourierToAdminDeptBalanceDetRepository repository;
    private final ModelMapper modelMapper;

    public CourierToAdminDeptBalanceDetImpl(CourierToAdminDeptBalanceDetRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    //ALL
    public List<CourierToAdminDeptBalanceDetDto> getAllCourierToAdminDeptBalanceDets() {
        List<CourierToAdminDeptBalanceDet> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, CourierToAdminDeptBalanceDetDto.class))
                .toList();
    }

    //ById
    public CourierToAdminDeptBalanceDetDto getCourierToAdminDeptBalanceDetById(Long id) {
        Optional<CourierToAdminDeptBalanceDet> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, CourierToAdminDeptBalanceDetDto.class)).orElse(null);
    }

    //Save
    public CourierToAdminDeptBalanceDetDto saveCourierToAdminDeptBalanceDet(CourierToAdminDeptBalanceDetDto dto) {
        CourierToAdminDeptBalanceDet det = modelMapper.map(dto, CourierToAdminDeptBalanceDet.class);
        det = repository.save(det);
        return modelMapper.map(det, CourierToAdminDeptBalanceDetDto.class);
    }

    //Delete
    public Boolean deleteCourierToAdminDeptBalanceDet(Long id) {
        Optional<CourierToAdminDeptBalanceDet> optional = repository.findById(id);
        if (optional.isPresent()) {
            CourierToAdminDeptBalanceDet det = optional.get();
            repository.delete(det);
            return true;
        }
        return false;
    }
}
