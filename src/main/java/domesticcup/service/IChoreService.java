
package domesticcup.service;

import domesticcup.dto.ChoreDto;
import domesticcup.dto.request.CreateChoreRequest;
import domesticcup.dto.request.UpdateChoreRequest;

import java.util.List;

public interface IChoreService {

    // Represents a household chore in the competition.

    List<ChoreDto> getAll();

    ChoreDto getById(long choreId);

    void create(CreateChoreRequest createChoreRequest);

    void update(long choreId, UpdateChoreRequest updateChoreRequest);

    void delete(long choreId);
}
