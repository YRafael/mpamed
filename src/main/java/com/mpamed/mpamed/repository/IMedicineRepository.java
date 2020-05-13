package com.mpamed.mpamed.repository;

import com.mpamed.mpamed.models.Medicine;
import com.mpamed.mpamed.models.MedicineDTO;
import org.springframework.data.domain.PageRequest;

import java.util.Map;

public interface IMedicineRepository {
    MedicineDTO findById(String id);

    Medicine findByName(String name);

    void save(MedicineDTO medicine);

    Medicine[] findAll();

    Medicine[] findAll(PageRequest of);

    Medicine[] getAllContraindications(String id);
}
