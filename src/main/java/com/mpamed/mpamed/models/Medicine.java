package com.mpamed.mpamed.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
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
    private int id;

    @NonNull
    @ApiModelProperty(notes = "Наименования препарата.")
    @Column
    private String name;

    @NonNull
    @ApiModelProperty(notes = "Противопоказания.")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "MedRefContraindications",
            joinColumns = @JoinColumn(name = "idContraindications"),
            inverseJoinColumns = @JoinColumn(name = "idMed")
    )
    private List<Contraindications> contraindications;

    @NonNull
    @ApiModelProperty(notes = "Флаг, показывающий рецептурность препарата.")
    @Column
    private boolean forReceipt;

    @NonNull
    @ApiModelProperty(notes = "Действующие вещества.")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "MedRefMNN",
            joinColumns = @JoinColumn(name = "idMNN"),
            inverseJoinColumns = @JoinColumn(name = "idMed")
    )
    private List<MNN> mnn;

}
