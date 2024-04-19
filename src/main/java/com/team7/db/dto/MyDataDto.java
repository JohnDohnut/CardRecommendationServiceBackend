package com.team7.db.dto;

import com.team7.db.model.entity.Customer;
import com.team7.db.model.entity.MyData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyDataDto {
    private Long mydataId;
    private int age;
    private String residence;
    private Boolean vehicleAvailability;
    private String lifeStage;
    private Customer customer;

    public MyDataDto(MyData myData){
        this.mydataId = myData.getMydataId();
        this.age = myData.getAge();
        this.residence = myData.getResidence();
        this.vehicleAvailability = myData.getVehicleAvailability();
        this.lifeStage = myData.getLifeStage();
        this.customer = myData.getCustomer();
    }
}
