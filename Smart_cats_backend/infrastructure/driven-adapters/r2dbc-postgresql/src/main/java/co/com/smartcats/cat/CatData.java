package co.com.smartcats.cat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;


@Table("gatos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CatData {

    @Id
    private int id;

    private String nombre;

    private int edad;

    private String raza;

    private int peso;

    @Column("tipo_comida")
    private String tipoComida;
}
