package com.team7.model.complex;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerMbtiId implements Serializable {

    private Long customerId;
    private Long MbtiId;

    // 생성자, getter, setter...

    // equals()와 hashCode() 오버라이드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerMbtiId that = (CustomerMbtiId) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(MbtiId, that.MbtiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, MbtiId);
    }
}
