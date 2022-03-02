package com.crm.siigroup.crmApp.models.specifications;

import com.crm.siigroup.crmApp.models.entity.Currency;
import com.crm.siigroup.crmApp.models.entity.Customers;
import org.springframework.data.jpa.domain.Specification;

import java.text.MessageFormat;
import java.util.Locale;

public final class CustomersSpecifications {

    public static Specification<Customers> personalIdContains(String personalId){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("personalId"),contains(personalId)));
    }

    public static Specification<Customers> nameContains(String name){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.upper(root.get("name")),contains(name.toUpperCase(Locale.ROOT))));
    }

    public static Specification<Customers> familyFirstNameContains(String familyFirstName){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.upper(root.get("familyFirstName")),
                        contains(familyFirstName.toUpperCase(Locale.ROOT))));
    }

    public static Specification<Customers> incomeRange(Long min, Long max) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.greaterThanOrEqualTo(root.get("income"), min),
                        criteriaBuilder.lessThanOrEqualTo(root.get("income"), max)
                );
    }

    public static Specification<Customers> currencyContains(Currency currency){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("currency"),currency));
    }

    public static Specification<Customers> tipeOfClientContains(int tipeOfClient){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("tipeOfClient"),tipeOfClient));
    }

    private static String contains(String expression) {
        return MessageFormat.format("{0}%", expression);
    }
}
