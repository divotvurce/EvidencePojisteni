package evidence.models.dto;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class PojistenecDTO {


    private long pojistenecId;

    @NotBlank(message = "Jméno nesmí být prázné")
    @Pattern(regexp = "^[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-záčďéěíňóřšťúůýž]*$", message = "Jméno musí začínat velkým písmenem a obsahovat pouze písmena")
    private String jmeno;

    @NotBlank(message = "Příjmení nesmí být prázné")
    @Pattern(regexp = "^[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-záčďéěíňóřšťúůýž]*$", message = "Příjmení musí začínat velkým písmenem a obsahovat pouze písmena")
    private String prijmeni;

    @NotBlank(message = "Email nesmí být prázný")
    @Email(message = "Email není ve správném formátu")
    private String email;

    @NotBlank(message = "Telefon nesmí být prázné")
    @Pattern(regexp = "\\d{9}", message = "Telefon musí obsahovat 9 číslic")
    private String telefon;

    @NotBlank(message = "Ulice nesmí být prázná")
    @Pattern(
            regexp = "^[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-zA-Z0-9áčďéěíňóřšťúůýž ]*$",
            message = "Ulice musí začínat velkým písmenem a může obsahovat pouze písmena, čísla a mezery"
    )
    private String ulice;

    @NotBlank(message = "Město nesmí být prázdné")
    @Pattern(
            regexp = "^[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-zA-Z0-9áčďéěíňóřšťúůýž ]*$",
            message = "Město musí začínat velkým písmenem a může obsahovat pouze písmena, čísla a mezery"
    )
    private String mesto;

    @NotBlank(message = "PSČ nesmí být prázné")
    @Pattern(regexp = "\\d{5}", message = "PSČ musí obsahovat 5 číslic")
    private String psc;

    private List<PojisteniDTO> pojisteni = new ArrayList<>();

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public long getPojistenecId() {
        return pojistenecId;
    }

    public void setPojistenecId(long pojistenecId) {
        this.pojistenecId = pojistenecId;
    }

    public List<PojisteniDTO> getPojisteni() {
        return pojisteni;
    }

    public void setPojisteni(List<PojisteniDTO> pojisteni) {
        this.pojisteni = pojisteni;
    }
}
