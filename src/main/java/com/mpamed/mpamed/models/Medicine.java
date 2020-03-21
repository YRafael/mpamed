package com.mpamed.mpamed.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@RequiredArgsConstructor
@Getter
@Setter
@ApiModel(description = "Вся необходимая информация про препарат.")
public class Medicine {

    @NonNull
    @ApiModelProperty(notes = "Сгенерированный базой данных ID.")
    private long id;

    @NonNull
    @ApiModelProperty(notes = "Наименования препарата.")
    private String name;

    @NonNull
    @ApiModelProperty(notes = "Противопоказания.")
    private List<String> contraindications;

    @NonNull
    @ApiModelProperty(notes = "Флаг, показывающий рецептурность препарата.")
    private boolean forReceipt;

    @NonNull
    @ApiModelProperty(notes = "Действующие вещества.")
    private List<String> mnn;

}
