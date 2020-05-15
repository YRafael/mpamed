package com.mpamed.mpamed.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.mongodb.BasicDBObject;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Document(collection = "Medicine")
public class MedicineDTO {

    public MedicineDTO(Map<String, Object> otherProps) {
        this.id = String.valueOf(otherProps.remove("id"));
        this.name = (String) otherProps.remove("name");
        this.contraindications = (List<String>) otherProps.remove("contraindications");
        this.forReceipt = (boolean) otherProps.remove("forReceipt");
        this.mnn = (List<String>) otherProps.remove("mnn");
        this.otherProps = new HashMap<>();
        this.otherProps.putAll(otherProps);
    }

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private List<String> contraindications;

    @NonNull
    private boolean forReceipt;

    public boolean isForReceipt() {
        return forReceipt;
    }

    @NonNull
    private List<String> mnn;

    private Map<String, Object> otherProps;

    @JsonAnySetter
    public void add(String key, Object value) {
        if (null == otherProps) {
            otherProps = new HashMap<>();
        }
        otherProps.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> get() {
        return otherProps;
    }

}
