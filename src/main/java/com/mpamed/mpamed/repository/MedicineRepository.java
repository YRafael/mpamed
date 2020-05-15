package com.mpamed.mpamed.repository;

import com.google.common.collect.Lists;
import com.mpamed.mpamed.models.Contraindications;
import com.mpamed.mpamed.models.MNN;
import com.mpamed.mpamed.models.Medicine;
import com.mpamed.mpamed.models.MedicineDTO;
import com.mpamed.mpamed.repository.mongo.MongoRepo;
import com.mpamed.mpamed.repository.postgre.PostgreRepo;
import com.mpamed.mpamed.utils.MedicineUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MedicineRepository implements IMedicineRepository {

    @NonNull
    private MongoRepo mongoRepo;
    @NonNull
    private PostgreRepo postgreRepo;


    @Override
    public MedicineDTO findById(String id) {
        return (mongoRepo.findById(id).isPresent() ? mongoRepo.findById(id).get() : null);
    }

    @Override
    public Medicine[] findByName(String name) {
        return postgreRepo.findByName(name);
    }

    @Override
    public void save(MedicineDTO medicine) {
        List<Contraindications> contraindicationsList = medicine.getContraindications().stream().map((Object s) -> {return new Contraindications((String)((Map)s).get("full_name"));}).collect(Collectors.toList());
        mongoRepo.save(medicine);
        postgreRepo.save(new Medicine(
                medicine.getName(),
                contraindicationsList,
                medicine.isForReceipt(),
                medicine.getMnn().stream().map((Object s) -> {return new MNN((String)((Map)s).get("full_name"));}).collect(Collectors.toList())
        ));
    }

    @Override
    public Medicine[] findAll() {
        Iterable<Medicine> all = postgreRepo.findAll();
        ArrayList<Medicine> medicines = Lists.newArrayList(all);
        return medicines.toArray(Medicine[]::new);
    }

    @Override
    public Medicine[] findAll(PageRequest of) {
        return postgreRepo.findAll(of).get().toArray(Medicine[]::new);
    }

    @Override
    public Medicine[] getAllContraindications(String id) {
        //return postgreRepo.findByIdMedRefContraindications(id);
        return MedicineUtils.generateArrayOfMedicine();
    }
}
