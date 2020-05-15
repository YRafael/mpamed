package com.mpamed.mpamed.utils;

import com.mpamed.mpamed.models.Contraindications;
import com.mpamed.mpamed.models.MNN;
import com.mpamed.mpamed.models.Medicine;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MedicineUtils {

    private static final String[] NAMES = new String[]{"Ибупрофен", "Нурофен", "Феназепам"};
    private static final String[] MNN = new String[]{"2-метил-2-метоксипропан", "2-феноксиэтанол", "2-фтор[18F]-L-тирозин"};

    public static Medicine[] generateArrayOfMedicine() {
        Random random = new Random();
        return Stream.generate(MedicineUtils::generateRandomMedicine).limit(random.nextInt(10)).toArray(Medicine[]::new);
    }

    public static Medicine[] generateArrayOfMedicine(int amount) {
        return Stream.generate(MedicineUtils::generateRandomMedicine).limit(amount).toArray(Medicine[]::new);
    }

    public static Medicine[] generateArrayOfMedicine(String from, String to) {
        return Stream.generate(MedicineUtils::generateRandomMedicine).limit(Integer.valueOf(to) - Integer.valueOf(from)).toArray(Medicine[]::new);
    }

    public static Medicine generateMedicineWithSpecifiedId(String id) {
        Medicine medicine = generateRandomMedicine();
        medicine.setId(Integer.valueOf(id));
        return medicine;
    }

    public static Medicine generateMedicineWithSpecifiedName(String name) {
        Medicine medicine = generateRandomMedicine();
        medicine.setName(name);
        return medicine;
    }

    private static Medicine generateRandomMedicine() {
        Random random = new Random();
        int id = random.nextInt(100);
        String name = NAMES[random.nextInt(3)];
        List<String> contraindications = generateRandomContraindications();
        boolean forReceipt = random.nextBoolean();
        List<String> mnn = generateRandomMNN();
        return getMedicine(id, name, contraindications, forReceipt, mnn);
    }

    private static Medicine getMedicine(int id, String name, List<String> contraindications, boolean forReceipt, List<String> mnn) {
        List<Contraindications> collectContraindications = contraindications.stream().map(contraindication -> new Contraindications( contraindication)).collect(Collectors.toList());
        List<com.mpamed.mpamed.models.MNN> collectMnn = mnn.stream().map(oneMnn -> new MNN( oneMnn)).collect(Collectors.toList());
        return new Medicine( name, collectContraindications, forReceipt, collectMnn);
    }

    private static List<String> generateRandomContraindications() {
        Random random = new Random();
        return Stream.generate(() -> NAMES[random.nextInt(3)]).limit(random.nextInt(10)).collect(Collectors.toList());
    }

    private static List<String> generateRandomMNN() {
        Random random = new Random();
        return Stream.generate(() -> MNN[random.nextInt(3)]).limit(random.nextInt(10)).collect(Collectors.toList());
    }
}
