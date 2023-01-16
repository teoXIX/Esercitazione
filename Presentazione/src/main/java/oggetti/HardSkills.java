package oggetti;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "HardSkills")
@Setter
@Getter
public class HardSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descrizione;

    private String livello;

    private String provenienza;

    public HardSkills(String descrizione, String livello, String provenienza){
        this.descrizione = descrizione;
        this.livello = livello;
        this.provenienza = provenienza;
    }

    public HardSkills() {

    }
}
