package evidence.data.entities;

import jakarta.persistence.*;

@Entity
public class KontaktEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zpravaId;

    @Column(nullable = false)
    private String jmeno;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String zprava;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZprava() {
        return zprava;
    }

    public void setZprava(String zprava) {
        this.zprava = zprava;
    }

    public long getZpravaId() {
        return zpravaId;
    }

    public void setZpravaId(long zpravaId) {
        this.zpravaId = zpravaId;
    }
}
