package com.cssrumi.services.map;

import com.cssrumi.model.Operation;
import com.cssrumi.services.OperationService;

import java.util.Set;

public class OperationServiceMap extends AbstractMapService<Operation, Long> implements OperationService {
    @Override
    public Set<Operation> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Operation save(Operation object) {
        return super.save(object);
    }

    @Override
    public void delete(Operation object) {
        super.delete(object);
    }

    @Override
    public Operation findById(Long id) {
        return map.get(id);
    }
}
