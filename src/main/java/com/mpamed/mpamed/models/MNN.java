package com.mpamed.mpamed.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@ApiModel(description = "Действующие вещества.")
@Entity
@Table(name = "MNN")
public class MNN {

    @ApiModelProperty(notes = "Сгенерированный базой данных ID.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NonNull
    @ApiModelProperty(notes = "Наименования действующего вещества.")
    @Column
    private String full_name;


    @Override
    public String toString() {
        return full_name;
    }
}
