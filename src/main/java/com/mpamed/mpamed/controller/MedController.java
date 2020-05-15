package com.mpamed.mpamed.controller;

import com.mpamed.mpamed.models.Medicine;
import com.mpamed.mpamed.handler.Handler;
import com.mpamed.mpamed.models.MedicineDTO;
import io.swagger.annotations.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "Medicine Management System", description = "Операции, относящиеся к препаратам в Medicine Management System.")
@RestController
@RequiredArgsConstructor
public class MedController {
    @NonNull
    Handler medicineHandler;

    @ApiOperation(value = "Получить препарат по идентификатору.", response = Medicine.class)
    @GetMapping("/getmedicinebyid")
    public MedicineDTO getMedicineById(@ApiParam(value = "Идентификатор препарата.", required = true) @RequestParam(value = "id", required = true) String id) {
        return medicineHandler.getMedicineById(id);
    }

    @ApiOperation(value = "Получить препарат по имени.", response = Medicine.class)
    @GetMapping("/getmedicinebyname")
    public Medicine[] getMedicineByName(@ApiParam(value = "Имя препарата.", required = true) @RequestParam(value = "name", required = true) String name) {
        return medicineHandler.getMedicineByName(name);
    }

    @ApiOperation(value = "Получить список всех препаратов на текущий момент.", response = Medicine[].class)
    @GetMapping("/getallmedicine")
    public Medicine[] getAllMedicine(@ApiParam(value = "Индекс начала.", required = false) @RequestParam(value = "from", required = false) String from,
                                     @ApiParam(value = "Индекс конца.", required = false) @RequestParam(value = "to", required = false) String to,
                                     @ApiParam(value = "Фиьтры.", required = false) @RequestParam(value = "filter", required = false) String filter) {
        if (to == null ^ from == null) {
            //TODO ERROR
            return null;
        } else {
            if (to == null) {
                return medicineHandler.getAllMedicine();
            } else {
                return medicineHandler.getAllMedicine(from, to);
            }
        }
    }

    @ApiOperation(value = "Получить список всех препаратов являющихся противопоказаниями к препарату с заданным идентификатором.", response = Medicine[].class)
    @GetMapping("/getcontraindications")
    public Medicine[] getContraindications(@ApiParam(value = "Идентификатор препарата.", required = true) @RequestParam(value = "id", required = true) String id) {
        return medicineHandler.getAllContraindications(id);
    }

    @ApiOperation(value = "Добавить препарат.")
    @PostMapping(path = "/addmedicine", consumes = "application/json")
    public Object addMedicine(@ApiParam(value = "JSON с полями препарата. Необходимые - name, contraindications, forReceipt, mnn.", required = true) @RequestBody(required = true) Map<String, Object> medicine) {
        if (!(medicine.containsKey("name")
                && medicine.containsKey("contraindications")
                && medicine.containsKey("forReceipt")
                && medicine.containsKey("mnn"))) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        medicineHandler.addMedicine(medicine);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
