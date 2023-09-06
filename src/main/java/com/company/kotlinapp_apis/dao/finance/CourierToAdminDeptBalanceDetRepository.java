package com.company.kotlinapp_apis.dao.finance;

import com.company.kotlinapp_apis.model.finance.CourierToAdminDeptBalanceDet;
import com.company.kotlinapp_apis.model.finance.CourierYourDeptBalanceDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierToAdminDeptBalanceDetRepository
        extends JpaRepository<CourierToAdminDeptBalanceDet, Long> {
}
