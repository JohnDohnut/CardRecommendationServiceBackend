package com.team7.model.complex;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OwnershipId implements Serializable {

    private Long customerId;
    private Long cardId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnershipId that = (OwnershipId) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, cardId);
    }
}