package domesticcup.service;

import domesticcup.dto.ParticipantDto;
import domesticcup.dto.request.CreateParticipantRequest;
import domesticcup.dto.request.UpdateParticipantRequest;

import java.util.List;

public interface IParticipantService {
    //Represents a person who participates in the challenge.

    List<ParticipantDto> getAll();
    ParticipantDto getById(long ParticipantId);

    void create(CreateParticipantRequest createParticipantRequest);

    void update(long ParticipantId, UpdateParticipantRequest updateParticipantRequest);

    void delete(long ParticipantId);

}
