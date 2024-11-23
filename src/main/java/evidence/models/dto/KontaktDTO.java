package evidence.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class KontaktDTO {

    @NotBlank(message = "Vyplňte jméno")
    private String jmeno;

    @NotBlank(message = "Vyplňte email")
    private String email;

    @NotBlank(message = "Vyplňte zprávu")
    private String zprava;

    public @NotBlank(message = "Vyplňte jméno") String getJmeno() {
        return jmeno;
    }

    public void setJmeno(@NotBlank(message = "Vyplňte jméno") String jmeno) {
        this.jmeno = jmeno;
    }

    public @NotBlank(message = "Vyplňte příjmení") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Vyplňte příjmení") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Vyplňte email") String getZprava() {
        return zprava;
    }

    public void setZprava(@NotBlank(message = "Vyplňte email") String zprava) {
        this.zprava = zprava;
    }
}
