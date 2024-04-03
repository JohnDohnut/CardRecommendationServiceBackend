package com.team7.model.complex;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class CardBenefitId implements Serializable {

    private Long cardId;
    private Long benefitId;

    // 생성자, getter, setter...

    // equals()와 hashCode() 오버라이드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardBenefitId that = (CardBenefitId) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(benefitId, that.benefitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, benefitId);
    }
}