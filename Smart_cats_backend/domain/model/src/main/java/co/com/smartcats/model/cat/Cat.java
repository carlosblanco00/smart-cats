package co.com.smartcats.model.cat;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cat {

    private int id;
    private String nombre;
    private int edad;
    private String raza;
    private int peso;
    private String tipoComida;
}
