package com.team7.service.entitiy;

import com.team7.db.model.entity.Customer;
import com.team7.db.model.entity.MyData;
import com.team7.db.repository.customer.MyDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MyDataSerice {
    private final MyDataRepository myDataRepository;

    public MyData findMyDataByMydataId(Long mydataId){
        MyData myData = myDataRepository.findMyDataByMydataId(mydataId);
        return myData;
    };

    public MyData findMyDataByCustomer(Customer customer){
        MyData myData = myDataRepository.findMyDataByCustomer(customer);
        return myData;
    };

    public ArrayList<MyData> findMyDatasByAge(int age){
        ArrayList<MyData> myDatas = myDataRepository.findMyDatasByAge(age);
        return myDatas;
    };

    public ArrayList<MyData> findMyDatasByResidence(String residence){
        ArrayList<MyData> myDatas = myDataRepository.findMyDatasByResidence(residence);
        return myDatas;
    };

    public ArrayList<MyData> findMyDatasByVehicleAvailability(Boolean vehicleAvaiability){
        ArrayList<MyData> myDatas = myDataRepository.findMyDatasByVehicleAvailability(vehicleAvaiability);
        return myDatas;
    };

    public ArrayList<MyData> findMyDatasByLifeStage(String lifeStage){
        ArrayList<MyData> myDatas = myDataRepository.findMyDatasByLifeStage(lifeStage);
        return myDatas;
    };


}
