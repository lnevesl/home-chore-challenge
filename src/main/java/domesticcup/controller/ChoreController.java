
package domesticcup.controller;

import domesticcup.dto.request.CreateChoreRequest;
import domesticcup.dto.request.UpdateChoreRequest;
import domesticcup.dto.response.*;
import domesticcup.exeption.CreateChoreException;
import domesticcup.exeption.DeleteChoreException;
import domesticcup.exeption.UpdateChoreException;
import domesticcup.service.IChoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chore")
public class ChoreController {

    private final IChoreService choreService;

    @GetMapping("")
    ResponseEntity<GetAllChoreResponse> getAll() {

        var choreList = choreService.getAll();

        var response = GetAllChoreResponse.builder()
                .chore(choreList)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{choreId}")
    ResponseEntity<GetChoreByIdResponse> getById(
            @PathVariable("choreId") Long choreId) {

        var chore = choreService.getById(choreId);

        var response = GetChoreByIdResponse.builder()
                .chore(chore)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    ResponseEntity<CreateChoreResponse> create(
            @RequestBody CreateChoreRequest createChoreRequest) {

        var response = CreateChoreResponse.builder();

        try {

            if (createChoreRequest.getChoreName() == null ||
                    createChoreRequest.getChoreName().isBlank()) {
                throw new CreateChoreException(
                        "Chore name is required"
                );
            }

            if (createChoreRequest.getChoreDescription() == null ||
                    createChoreRequest.getChoreDescription().isBlank()) {
                throw new CreateChoreException(
                        "Chore description is required"
                );
            }

            if (createChoreRequest.getActive() == null) {
                throw new CreateChoreException(
                        "Chore activity is required"
                );
            }

            choreService.create(createChoreRequest);

            return ResponseEntity
                    .status(201)
                    .body(response.mensagem(
                            "Chore created successfully"
                    ).build());

        } catch (CreateChoreException exception) {

            return ResponseEntity.badRequest().body(
                    response.mensagem(exception.getMessage()).build()
            );

        } catch (Exception exception) {

            return ResponseEntity.internalServerError().body(
                    response.mensagem("Error creating chore").build()
            );
        }
    }

    @PatchMapping("/{choreId}")
    ResponseEntity<UpdateChoreResponse> update(
            @PathVariable("choreId") Long choreId,
            @RequestBody UpdateChoreRequest updateChoreRequest) {

        var response = UpdateChoreResponse.builder();

        try {

            choreService.update(choreId, updateChoreRequest);

            return ResponseEntity
                    .status(200)
                    .body(response.mensagem(
                            "Chore updated successfully"
                    ).build());

        } catch (UpdateChoreException updateChoreException) {

            return ResponseEntity.badRequest().body(
                    response.mensagem(updateChoreException.getMessage()).build()
            );

        } catch (Exception exception) {

            return ResponseEntity.internalServerError().body(
                    response.mensagem("Error updating chore").build()
            );
        }
    }

    @DeleteMapping("/{choreId}")
    ResponseEntity<DeleteChoreResponse> delete(
            @PathVariable("choreId") Long choreId) {

        var response = DeleteChoreResponse.builder();

        try {

            choreService.delete(choreId);

            return ResponseEntity
                    .status(200)
                    .body(response.mensagem(
                            "Chore deleted successfully"
                    ).build());

        } catch (DeleteChoreException exception) {

            return ResponseEntity.badRequest().body(
                    response.mensagem(exception.getMessage()).build()
            );

        } catch (Exception exception) {

            return ResponseEntity.internalServerError().body(
                    response.mensagem("Error deleting chore").build()
            );
        }
    }
}
