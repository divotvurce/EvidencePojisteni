package evidence.models.services;

import evidence.models.dto.PojistenecDTO;

import java.util.List;

public interface PojistenecService {

    void create (PojistenecDTO pojistenec);

    List<PojistenecDTO> getAll();

    PojistenecDTO getById(long pojistenecId);

    void edit(PojistenecDTO pojistenec);

    void remove(long pojistenecId);
}
