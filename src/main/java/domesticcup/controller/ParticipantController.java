
package domesticcup.controller;

import domesticcup.dto.request.CreateParticipantRequest;
import domesticcup.dto.request.UpdateParticipantRequest;
import domesticcup.dto.response.*;
import domesticcup.exeption.CreateParticipantException;
import domesticcup.exeption.DeleteParticipantException;
import domesticcup.exeption.UpdateParticipantException;
import domesticcup.service.IParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/participant")
public class ParticipantController {

    private final IParticipantService participantService;

    @GetMapping("")
    ResponseEntity<GetAllParticipantResponse> getAll() {

        var participantList = participantService.getAll();

        var response = GetAllParticipantResponse.builder()
                .participant(participantList)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{participantId}")
    ResponseEntity<GetParticipantByIdResponse> getById(
            @PathVariable("participantId") Long participantId) {

        var participant = participantService.getById(participantId);

        var response = GetParticipantByIdResponse.builder()
                .participant(participant)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    ResponseEntity<CreateParticipantResponse> create(
            @RequestBody CreateParticipantRequest createParticipantRequest) {

        var response = CreateParticipantResponse.builder();

        try {

            if (createParticipantRequest.getParticipantName() == null ||
                    createParticipantRequest.getParticipantName().isBlank()) {
                throw new CreateParticipantException(
                        "Participant name is required"
                );
            }

            if (createParticipantRequest.getActive() == null) {
                throw new CreateParticipantException(
                        "Participant activity is required"
                );
            }

            participantService.create(createParticipantRequest);

            return ResponseEntity
                    .status(201)
                    .body(response.mensagem(
                            "Participant created successfully"
                    ).build());

        } catch (CreateParticipantException exception) {

            return ResponseEntity.badRequest().body(
                    response.mensagem(exception.getMessage()).build()
            );

        } catch (Exception exception) {

            return ResponseEntity.internalServerError().body(
                    response.mensagem("Error creating participant").build()
            );
        }
    }

    @PatchMapping("/{participantId}")
    ResponseEntity<UpdateParticipantResponse> update(
            @PathVariable("participantId") Long participantId,
            @RequestBody UpdateParticipantRequest updateParticipantRequest) {

        var response = UpdateParticipantResponse.builder();

        try {

            participantService.update(participantId, updateParticipantRequest);

            return ResponseEntity
                    .status(200)
                    .body(response.mensagem(
                            "Participant updated successfully"
                    ).build());

        } catch (UpdateParticipantException updateParticipantException) {

            return ResponseEntity.badRequest().body(
                    response.mensagem(updateParticipantException.getMessage()).build()
            );

        } catch (Exception exception) {

            return ResponseEntity.internalServerError().body(
                    response.mensagem("Error updating participant").build()
            );
        }
    }

    @DeleteMapping("/{participantId}")
    ResponseEntity<DeleteParticipantResponse> delete(
            @PathVariable("participantId") Long participantId) {

        var response = DeleteParticipantResponse.builder();

        try {

            participantService.delete(participantId);

            return ResponseEntity
                    .status(200)
                    .body(response.mensagem(
                            "Participant deleted successfully"
                    ).build());

        } catch (DeleteParticipantException exception) {

            return ResponseEntity.badRequest().body(
                    response.mensagem(exception.getMessage()).build()
            );

        } catch (Exception exception) {

            return ResponseEntity.internalServerError().body(
                    response.mensagem("Error deleting participant").build()
            );
        }
    }
}
