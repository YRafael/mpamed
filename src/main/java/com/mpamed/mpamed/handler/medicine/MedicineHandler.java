package com.mpamed.mpamed.handler.medicine;

import com.mpamed.mpamed.handler.Handler;
import com.mpamed.mpamed.models.Medicine;
import com.mpamed.mpamed.models.MedicineDTO;
import com.mpamed.mpamed.repository.IMedicineRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.mpamed.mpamed.utils.MedicineUtils.generateArrayOfMedicine;
import static com.mpamed.mpamed.utils.MedicineUtils.generateMedicineWithSpecifiedId;
import static com.mpamed.mpamed.utils.MedicineUtils.generateMedicineWithSpecifiedName;

@Component
@RequiredArgsConstructor
public class MedicineHandler implements Handler {

    @NonNull IMedicineRepository medicineRepository;

    @Override
    public MedicineDTO getMedicineById(String id)
    {
        return medicineRepository.findById(id);
    }

    @Override
    public Medicine getMedicineByName(String name)
    {
        return medicineRepository.findByName(name);
    }

    @Override
    public Medicine[] getAllMedicine() {
        return medicineRepository.findAll();
    }

    @Override
    public void addMedicine(Map<String, Object> medicine) {
        medicineRepository.save(new MedicineDTO(medicine));
    }

    @Override
    public Medicine[] getAllMedicine(String from, String to) {
        PageRequest of = PageRequest.of(Integer.valueOf(from), Integer.valueOf(to));
        return medicineRepository.findAll(of);
    }

    @Override
    public Medicine[] getAllContraindications(String id) {
        return medicineRepository.getAllContraindications(id);
    }
}
