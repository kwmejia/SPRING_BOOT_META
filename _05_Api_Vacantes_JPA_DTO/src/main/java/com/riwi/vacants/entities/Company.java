package com.riwi.vacants.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 60, nullable = false)
    private String location;
    @Column(length = 15, nullable = false)
    private String contact;

    /**
     * @OneToMany: (Uno a muchos) Una empresa puede tener muchas vacantes
     * @ MapedBy: Debemos especificar en que propiedad se está mapeando en la otra
     * entidad
     * Cascade.All: Especificamos el tipo cascada, All quiere decir que tendrá todos
     * los tipos de cascada
     * orphanRemoval -> Espeficar que un objeto huerfano (sin llave foranea) sera
     * eliminado
     */

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude // excluimos esta propiedad del to string
    @EqualsAndHashCode.Exclude // excluimos las propiedades dentro la lista
    private List<Vacant> vacants;
}
