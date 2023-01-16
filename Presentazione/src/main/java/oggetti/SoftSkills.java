package oggetti;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SoftSkills")
@Setter
@Getter
public class SoftSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descrizione;

    private String livello;

    public SoftSkills(String descrizione, String livello){
        this.descrizione = descrizione;
        this.livello = livello;
    }

    public SoftSkills() {

    }
}
