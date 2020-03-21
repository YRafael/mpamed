package com.mpamed.mpamed.handler.medicine;

import com.mpamed.mpamed.handler.Handler;
import com.mpamed.mpamed.models.Medicine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.mpamed.mpamed.utils.MedicineUtils.generateArrayOfMedicine;
import static com.mpamed.mpamed.utils.MedicineUtils.generateMedicineWithSpecifiedId;
import static com.mpamed.mpamed.utils.MedicineUtils.generateMedicineWithSpecifiedName;

@Component
public class MedicineHandler implements Handler {
    @Override
    public Medicine getMedicineById(String id) {
        return generateMedicineWithSpecifiedId(id);
    }

    @Override
    public Medicine getMedicineByName(String name) {
        return generateMedicineWithSpecifiedName(name);
    }

    @Override
    public Medicine[] getAllMedicine() {
        return generateArrayOfMedicine();
    }

    @Override
    public void addMedicine(Map<String, Object> medicine) {
    }

    @Override
    public Medicine[] getAllMedicine(String from, String to) {
        return generateArrayOfMedicine(from, to);
    }

    @Override
    public Medicine[] getAllContraindications(String id) {
        return generateArrayOfMedicine();
    }
}
