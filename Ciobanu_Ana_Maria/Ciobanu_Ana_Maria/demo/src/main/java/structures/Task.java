package structures;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String TITLU;
    private String DESCRIERE;
    private LocalDate DATA_SPECIFICA;
    private LocalTime ORA_SPECIFICA;

    // Noile câmpuri
    private String GRATITUDINE;
    private String IMBUNATATIRI;

    public Task() {
    }

    public Task(String TITLU, String DESCRIERE, LocalDate DATA_SPECIFICA, LocalTime ORA_SPECIFICA, String GRATITUDINE, String IMBUNATATIRI) {
        this.TITLU = TITLU;
        this.DESCRIERE = DESCRIERE;
        this.DATA_SPECIFICA = DATA_SPECIFICA;
        this.ORA_SPECIFICA = ORA_SPECIFICA;
        this.GRATITUDINE = GRATITUDINE;
        this.IMBUNATATIRI = IMBUNATATIRI;
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getTitlu() {
        return TITLU;
    }

    public void setTitlu(String titlu) {
        this.TITLU = titlu;
    }

    public String getDescriere() {
        return DESCRIERE;
    }

    public void setDescriere(String descriere) {
        this.DESCRIERE = descriere;
    }

    public LocalDate getDataSpecifica() {
        return DATA_SPECIFICA;
    }

    public void setDataSpecifica(LocalDate dataSpecifica) {
        this.DATA_SPECIFICA = dataSpecifica;
    }

    public LocalTime getOraSpecifica() {
        return ORA_SPECIFICA;
    }

    public void setOraSpecifica(LocalTime oraSpecifica) {
        this.ORA_SPECIFICA = oraSpecifica;
    }

    // Getter și setter pentru noile câmpuri
    public String getGratitudine() {
        return GRATITUDINE;
    }

    public void setGratitudine(String gratitudine) {
        this.GRATITUDINE = gratitudine;
    }

    public String getImbunatatiri() {
        return IMBUNATATIRI;
    }

    public void setImbunatatiri(String imbunatatiri) {
        this.IMBUNATATIRI = imbunatatiri;
    }

    @Override
    public String toString() {
        return "Task{" +
               "ID=" + ID +
               ", TITLU='" + TITLU + '\'' +
               ", DESCRIERE='" + DESCRIERE + '\'' +
               ", DATA_SPECIFICA=" + DATA_SPECIFICA +
               ", ORA_SPECIFICA=" + ORA_SPECIFICA +
               ", GRATITUDINE='" + GRATITUDINE + '\'' +
               ", IMBUNATATIRI='" + IMBUNATATIRI + '\'' +
               '}';
    }
}
