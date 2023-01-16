package oggetti;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Progetti")
@Setter
@Getter
public class Progetti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descrizione;

    private String link;

    public Progetti(String nome, String descrizione, String link){
        this.descrizione = descrizione;
        this.nome = nome;
        this.link = link;
    }

    public Progetti() {

    }
}
