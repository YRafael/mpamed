package com.mpamed.mpamed.handler;

import com.mpamed.mpamed.models.Medicine;

import java.util.Map;

public interface Handler {
    Medicine getMedicineById(String id);

    Medicine getMedicineByName(String name);

    Medicine[] getAllMedicine();

    Medicine[] getAllContraindications(String id);

    void addMedicine(Map<String, Object> medicine);

    Medicine[] getAllMedicine(String from, String to);
}
