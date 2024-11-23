package evidence.models.services;

import evidence.models.dto.PojistenecDTO;
import evidence.models.dto.PojisteniDTO;

import java.util.List;

public interface PojisteniService {

    void create (PojisteniDTO pojisteni);

    PojisteniDTO getById(long pojisteniId);

    void edit(PojisteniDTO pojisteni);

    void remove(long pojisteniId);
}