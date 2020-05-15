package com.mpamed.mpamed.handler;

import com.mpamed.mpamed.models.Medicine;
import com.mpamed.mpamed.models.MedicineDTO;

import java.util.Map;

public interface Handler {
    MedicineDTO getMedicineById(String id);

    Medicine[] getMedicineByName(String name);

    Medicine[] getAllMedicine();

    Medicine[] getAllContraindications(String id);

    void addMedicine(Map<String, Object> medicine);

    Medicine[] getAllMedicine(String from, String to);
}
