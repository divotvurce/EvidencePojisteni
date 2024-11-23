package evidence.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PojisteniDTO {

    private long pojisteniId;

    @NotBlank(message = "Vyplňte typ pojištění")
    private String typ;

    @NotBlank(message = "Vyplňte částku")
    private String castka;

    @NotBlank(message = "Vyplňte předmět pojištění")
    private String predmet;

    @NotBlank(message = "Vyplňte odkdy pojištění platí")
    private String platnostOd;

    @NotBlank(message = "Vyplňte dokdy pojištění platí")
    private String platnostDo;

    private long pojistenecId;

    public long getPojisteniId() {
        return this.pojisteniId;
    }

    public void setPojisteniId(long pojisteniId) {
        this.pojisteniId = pojisteniId;
    }

    public @NotBlank(message = "Vyplňte typ pojištění") String getTyp() {
        return typ;
    }

    public void setTyp(@NotBlank(message = "Vyplňte typ pojištění") String typ) {
        this.typ = typ;
    }

    public @NotBlank(message = "Vyplňte částku") String getCastka() {
        return castka;
    }

    public void setCastka(@NotBlank(message = "Vyplňte částku") String castka) {
        this.castka = castka;
    }

    public @NotBlank(message = "Vyplňte předmět pojištění") String getPredmet() {
        return predmet;
    }

    public void setPredmet(@NotBlank(message = "Vyplňte předmět pojištění") String predmet) {
        this.predmet = predmet;
    }

    public @NotBlank(message = "Vyplňte odkdy pojištění platí") String getPlatnostOd() {
        return platnostOd;
    }

    public void setPlatnostOd(@NotBlank(message = "Vyplňte odkdy pojištění platí") String platnostOd) {
        this.platnostOd = platnostOd;
    }

    public @NotBlank(message = "Vyplňte dokdy pojištění platí") String getPlatnostDo() {
        return platnostDo;
    }

    public void setPlatnostDo(@NotBlank(message = "Vyplňte dokdy pojištění platí") String platnostDo) {
        this.platnostDo = platnostDo;
    }

    public long getPojistenecId() {
        return pojistenecId;
    }

    public void setPojistenecId(long pojistenecId) {
        this.pojistenecId = pojistenecId;
    }
}

