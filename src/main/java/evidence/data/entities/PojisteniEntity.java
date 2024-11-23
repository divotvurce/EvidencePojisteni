package evidence.data.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PojisteniEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pojisteniId;

    @Column(nullable = false)
    private String typ;

    @Column(nullable = false)
    private String castka;

    @Column(nullable = false)
    private String predmet;

    @Column(nullable = false)
    private String platnostOd;

    @Column(nullable = false)
    private String platnostDo;

    @ManyToOne
    @JoinColumn(name = "pojistenec_id", nullable = false)
    private PojistenecEntity pojistenec;

    public long getPojisteniId() {
        return pojisteniId;
    }

    public void setPojisteniId(long pojisteniId) {
        this.pojisteniId = pojisteniId;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getCastka() {
        return castka;
    }

    public void setCastka(String castka) {
        this.castka = castka;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getPlatnostOd() {
        return platnostOd;
    }

    public void setPlatnostOd(String platnostOd) {
        this.platnostOd = platnostOd;
    }

    public String getPlatnostDo() {
        return platnostDo;
    }

    public void setPlatnostDo(String platnostDo) {
        this.platnostDo = platnostDo;
    }

    public PojistenecEntity getPojistenec() {
        return pojistenec;
    }

    public void setPojistenec(PojistenecEntity pojistenec) {
        this.pojistenec = pojistenec;
    }
}
