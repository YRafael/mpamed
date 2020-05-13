package com.mpamed.mpamed.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@RequiredArgsConstructor
@Getter
@Setter
@ApiModel(description = "Вся необходимая информация про препарат.")
@Entity
@Table(name = "Medicine")
public class Medicine {

    @ApiModelProperty(notes = "Сгенерированный базой данных ID.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NonNull
    @ApiModelProperty(notes = "Наименования препарата.")
    @Column
    private String name;

    @NonNull
    @ApiModelProperty(notes = "Противопоказания.")
    @ManyToMany
    @JoinTable(
            name = "MedRefContraindications",
            joinColumns = @JoinColumn(name = "idMed"),
            inverseJoinColumns = @JoinColumn(name = "idContraindications")
    )
    private List<Contraindications> contraindications;

    @NonNull
    @ApiModelProperty(notes = "Флаг, показывающий рецептурность препарата.")
    @Column
    private boolean forReceipt;

    @NonNull
    @ApiModelProperty(notes = "Действующие вещества.")
    @ManyToMany
    @JoinTable(
            name = "MedRefMNN",
            joinColumns = @JoinColumn(name = "idMed"),
            inverseJoinColumns = @JoinColumn(name = "idMNN")
    )
    private List<MNN> mnn;

}
