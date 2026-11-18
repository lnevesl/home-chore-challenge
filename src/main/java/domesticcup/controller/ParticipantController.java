package domesticcup.controller;

import domesticcup.dto.request.CreateParticipantRequest;
import domesticcup.dto.request.UpdateParticipantRequest;
import domesticcup.dto.response.*;
import domesticcup.exeption.CreateParticipantException;
import domesticcup.exeption.DeleteParticipantException;
import domesticcup.exeption.UpdateParticipantException;
import domesticcup.service.IParticipantService;
import lombok.RequiredArgsConstructor;
import lombok.var;


@RequiredArgsConstructor
@Controller
@RequestMapping("/participant")
public class ParticipantController {

    private final IParticipantService iParticipantService;


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

        //var getEventByIdResponseBuilder = GetParticipantByIdResponse.builder();

        var participant = iParticipantService.getById(participantId);
        var response = GetParticipantByIdResponse.builder()
                .participant(participant)
                .build();

        return ResponseEntity.ok(response);
    }

        @PostMapping("")
        ResponseEntity<CreateParticipantResponse> create (CreateParticipantException createParticipantRequest){
            var response = CreateParticipantResponse.builder();

            try {
                if (CreateParticipantRequest.getName() == null) {
                    throw new CreateParticipantException("Participant name is required");
                }

                if (CreateParticipantRequest.getActive() == null) {
                    throw new CreateParticipantException("Participant activity is required.");
                }

                participantService.create(createParticipantRequest);

                return ResponseEntity
                        .status(201)
                        .body(
                                response.mensagem("Participant created successfully.").build()
                        );
            } catch (CreateParticipantException createParticipantException) {
                return ResponseEntity.badRequest().body(
                        response.mensagem(createParticipantException.getMessage()).build());
            } catch (Exception exception) {
                return ParticipantEntity.internalServerError().body(
                        response.mensagem("Error creating participant").build());
            }
        }

        @PatchMapping("/{participantId}")
        ResponseEntity<UpdateParticipantResponse> update (
                @PathVariable("participantId") Long participantId, UpdateParticipantRequest updateParticipantRequest){
            var response = UpdateParticipantResponse.builder();
            try {
                participantService.update(participantId, updateParticipantRequest);

                return ResponseEntity
                        .status(200)
                        .body(
                                response.mensagem("PParticipant successfully updated").build());
            } catch (UpdateParticipantException updateParticipantException) {
                return ResponseEntity.badRequest().body(
                        response.mensagem(updateParticipantException.getMessage()).build());
            } catch (Exception exception) {
                return ResponseEntity.internalServerError().body(
                        response.mensagem("Error updating the participant!").build());
            }
        }

        @DeleteMapping("/{participantId}")
        ResponseEntity<DeleteParticipantResponse> delete (@PathVariable("participantId") Long participantId){
            var response = DeleteParticipantResponse.builder();
            try {
                participantService.delete(participantId);

                return ResponseEntity
                        .status(200)
                        .body(
                                response.mensagem("Event successfully deleted").build());
            } catch (DeleteParticipantException deleteParticipantException) {
                return ResponseEntity.badRequest().body(
                        response.mensagem(deleteParticipantException.getMessage()).build());
            } catch (Exception exception) {
                return ResponseEntity.internalServerError().body(
                        response.mensagem("Error deleting the event!").build());
            }
        }

    }