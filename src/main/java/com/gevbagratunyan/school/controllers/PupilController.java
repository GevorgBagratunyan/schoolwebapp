package com.gevbagratunyan.school.controllers;

import com.gevbagratunyan.school.entity.data.AllMarks;
import com.gevbagratunyan.school.entity.models.Pupil;
import com.gevbagratunyan.school.service.services.PupilService;
import com.gevbagratunyan.school.transfer.pupil.PupilResponse;
import com.gevbagratunyan.school.transfer.user.request.PupilCreateRequest;
import com.gevbagratunyan.school.transfer.user.request.PupilSetMarkRequest;
import com.gevbagratunyan.school.transfer.user.request.PupilUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/pupils")
public class PupilController {

    private final PupilService pupilService;

    public PupilController(PupilService pupilService) {
        this.pupilService = pupilService;
    }

    @GetMapping("/id}")
    public PupilResponse getPupil(@PathVariable Long id) {
        return pupilService.get(id);
    }

    @PostMapping("")
    public ResponseEntity<PupilResponse> createPupil(@Valid @RequestBody PupilCreateRequest pupilCreateRequest) {
        PupilResponse response = pupilService.add(pupilCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/set-year-mark/{id}")
    public ResponseEntity<Void> setYearMark(@PathVariable Long id, @Valid @RequestBody PupilSetMarkRequest setMarkRequest) {
        pupilService.setYearMark(id,setMarkRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/set-all-year-marks/{id}")
    public ResponseEntity<Void> setAllYearMarks(@PathVariable Long id) {
        pupilService.setAllYearMarks(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/set-mark/{id}")
    public ResponseEntity<Void> setMark(@PathVariable Long id, @Valid @RequestBody PupilSetMarkRequest setMarkRequest) {
        pupilService.setMark(id,setMarkRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-current-marks/{id}")
    public ResponseEntity<AllMarks> getCurrentMarks(@PathVariable Long id){
        AllMarks marks = pupilService.getCurrentMarks(id);
        return new ResponseEntity<>(marks,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePupil(@PathVariable Long id){
        pupilService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Pupil>> getPupils(){
        List<Pupil> pupils = pupilService.getAllPupils();
        return new ResponseEntity<>(pupils, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public PupilResponse updatePupil(@PathVariable Long id, @Valid @RequestBody PupilUpdateRequest updateRequest){
        return pupilService.update(id, updateRequest);
    }
}
