package com.company.kotlinapp_apis.service.impl.finance;

import com.company.kotlinapp_apis.dao.finance.CourierYourDeptBalanceDetRepository;
import com.company.kotlinapp_apis.dto.finance.CourierYourDeptBalanceDetDto;
import com.company.kotlinapp_apis.model.finance.CourierYourDeptBalanceDet;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierYourDeptBalanceDetImpl {

    private final CourierYourDeptBalanceDetRepository repository;
    private final ModelMapper modelMapper;

    public CourierYourDeptBalanceDetImpl(CourierYourDeptBalanceDetRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    //ALL
    public List<CourierYourDeptBalanceDetDto> getAllCourierYourDeptBalanceDets() {
        List<CourierYourDeptBalanceDet> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, CourierYourDeptBalanceDetDto.class))
                .toList();
    }

    //ById
    public CourierYourDeptBalanceDetDto getCourierYourDeptBalanceDetById(Long id) {
        Optional<CourierYourDeptBalanceDet> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, CourierYourDeptBalanceDetDto.class)).orElse(null);
    }

    //Save
    public CourierYourDeptBalanceDetDto saveCourierYourDeptBalanceDet(CourierYourDeptBalanceDetDto dto) {
        CourierYourDeptBalanceDet det = modelMapper.map(dto, CourierYourDeptBalanceDet.class);
        det = repository.save(det);
        return modelMapper.map(det, CourierYourDeptBalanceDetDto.class);
    }

    //Delete
    public Boolean deleteCourierYourDeptBalanceDet(Long id) {
        Optional<CourierYourDeptBalanceDet> optional = repository.findById(id);
        if (optional.isPresent()) {
            CourierYourDeptBalanceDet det = optional.get();
            repository.delete(det);
            return true;
        }
        return false;
    }
}
