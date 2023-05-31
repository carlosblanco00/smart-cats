package co.com.smartcats.model.movements;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movements {

    private int id;
    private int gatoId;
    private String componente;
    private LocalDateTime createdAt;
}
