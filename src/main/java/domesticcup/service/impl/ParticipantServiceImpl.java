
package domesticcup.service.impl;

import domesticcup.dto.ParticipantDto;
import domesticcup.dto.request.CreateParticipantRequest;
import domesticcup.dto.request.UpdateParticipantRequest;
import domesticcup.entity.ParticipantEntity;
import domesticcup.exeption.CreateParticipantException;
import domesticcup.exeption.DeleteParticipantException;
import domesticcup.exeption.GetParticipantByIdException;
import domesticcup.exeption.UpdateParticipantException;
import domesticcup.repository.ParticipantRepository;
import domesticcup.service.IParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements IParticipantService {

    private final ParticipantRepository participantRepository;

    @Override
    public List<ParticipantDto> getAll() {

        var participantList = participantRepository.findAll()
                .stream()
                .map(participantEntity -> ParticipantDto.builder()
                        .participantId(participantEntity.getParticipantId())
                        .participantName(participantEntity.getParticipantName())
                        .build())
                .toList();

        return participantList;
    }

    @Override
    public ParticipantDto getById(long participantId) {

        var participantEntityOptional = participantRepository.findById(participantId);

        if (participantEntityOptional.isEmpty()) {
            throw new GetParticipantByIdException(
                    "Participant not found with ID " + participantId
            );
        }

        var participantEntity = participantEntityOptional.get();

        return ParticipantDto.builder()
                .participantId(participantEntity.getParticipantId())
                .participantName(participantEntity.getParticipantName())
                .build();
    }

    @Override
    public void create(CreateParticipantRequest createParticipantRequest) {

        var participantEntity = ParticipantEntity.builder()
                .participantName(createParticipantRequest.getName())
                .isActive(createParticipantRequest.getActive())
                .createAt(LocalDateTime.now())
                .build();

        participantRepository.save(participantEntity);
    }

    @Override
    public void update(long participantId, UpdateParticipantRequest updateParticipantRequest) {

        var participantEntityOptional = participantRepository.findById(participantId);

        if (participantEntityOptional.isEmpty()) {
            throw new UpdateParticipantException(
                    "Participant not found with ID " + participantId
            );
        }

        var participantEntity = participantEntityOptional.get();

        participantEntity.setParticipantName(updateParticipantRequest.getName());
        participantEntity.setActive(updateParticipantRequest.getActive());
        participantEntity.setUpdateAt(LocalDateTime.now());

        participantRepository.save(participantEntity);
    }

    @Override
    public void delete(long participantId) {

        var participantEntityOptional = participantRepository.findById(participantId);

        if (participantEntityOptional.isEmpty()) {
            throw new DeleteParticipantException(
                    "Participant not found with ID " + participantId
            );
        }

        var participantEntity = participantEntityOptional.get();

        participantEntity.setActive(false);
        participantEntity.setUpdateAt(LocalDateTime.now());

        participantRepository.save(participantEntity);
    }
}
