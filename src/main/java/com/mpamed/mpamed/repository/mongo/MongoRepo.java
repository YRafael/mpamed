package com.mpamed.mpamed.repository.mongo;

import com.mpamed.mpamed.models.Medicine;
import com.mpamed.mpamed.models.MedicineDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository<MedicineDTO, String> {
    MedicineDTO findByName(String name);
}
