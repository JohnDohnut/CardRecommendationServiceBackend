package com.team7.repository.card;

import com.team7.model.entity.Card;
import com.team7.model.entity.Customer;
import com.team7.model.relationship.Ownership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface OwnershipRepository extends JpaRepository<Ownership, Long> {

    public ArrayList<Ownership> findOwnershipsByCustomer(Customer customer);
    public ArrayList<Ownership> findOwnershipByCard(Card card);

}
