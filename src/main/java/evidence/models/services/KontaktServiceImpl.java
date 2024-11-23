package evidence.models.services;

import evidence.data.entities.KontaktEntity;
import evidence.data.repositories.KontaktRepository;
import evidence.models.dto.KontaktDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class KontaktServiceImpl implements KontaktService {

    @Autowired
    private KontaktRepository kontaktRepository;

    @Override
    public void create(KontaktDTO kontakt) {
        KontaktEntity newKontakt = new KontaktEntity();

        newKontakt.setJmeno(kontakt.getJmeno());
        newKontakt.setEmail(kontakt.getEmail());
        newKontakt.setZprava(kontakt.getZprava());
        kontaktRepository.save(newKontakt);
    }
}
