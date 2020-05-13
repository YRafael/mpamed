package com.mpamed.mpamed.repository.postgre;

import com.mpamed.mpamed.models.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PostgreRepo extends CrudRepository<Medicine, String>, PagingAndSortingRepository<Medicine, String> {
    Medicine findByName(String name);
    Medicine[] findByIdMedRefContraindications(String id);
}
