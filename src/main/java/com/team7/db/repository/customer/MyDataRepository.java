package com.team7.db.repository.customer;

import com.team7.db.model.entity.Customer;
import com.team7.db.model.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

    public MyData findMyDataByMydataId(Long mydataId);

    public Optional<MyData> findMyDataByCustomer(Customer customer);

    public ArrayList<MyData> findMyDatasByAge(int age);

    public ArrayList<MyData> findMyDatasByResidence(String residence);

    public ArrayList<MyData> findMyDatasByVehicleAvailability(Boolean vehicleAvaiability);

    public ArrayList<MyData> findMyDatasByLifeStage(String lifeStage);

}
