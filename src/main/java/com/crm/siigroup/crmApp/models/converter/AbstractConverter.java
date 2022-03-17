package com.crm.siigroup.crmApp.models.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {

    public abstract D fromEntity(E entity);

    public List<D> fromEntity(List<E> entities){
        if(entities == null) return null;
        return entities.stream().map(entity -> fromEntity(entity)).collect(Collectors.toList());
    }
}
