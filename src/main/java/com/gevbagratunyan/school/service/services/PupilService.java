package com.gevbagratunyan.school.service.services;

import com.gevbagratunyan.school.entity.data.AllMarks;
import com.gevbagratunyan.school.entity.data.FinalYearMarks;
import com.gevbagratunyan.school.entity.enums.Subject;
import com.gevbagratunyan.school.entity.models.Pupil;
import com.gevbagratunyan.school.repository.PupilRepo;
import com.gevbagratunyan.school.service.crud.CreateSupported;
import com.gevbagratunyan.school.service.crud.DeleteSupported;
import com.gevbagratunyan.school.service.crud.ReadSupported;
import com.gevbagratunyan.school.service.crud.UpdateSupported;
import com.gevbagratunyan.school.service.managers.MarksManager;
import com.gevbagratunyan.school.transfer.user.request.PupilCreateRequest;
import com.gevbagratunyan.school.transfer.user.request.PupilSetMarkRequest;
import com.gevbagratunyan.school.transfer.user.request.PupilUpdateRequest;
import com.gevbagratunyan.school.transfer.pupil.PupilResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PupilService implements CreateSupported<PupilCreateRequest,
        PupilResponse>, ReadSupported<Long, PupilResponse>,
        UpdateSupported<Long, PupilUpdateRequest, PupilResponse>,
        DeleteSupported<Long> {

    private final PupilRepo pupilRepository;
    private MarksManager marksManager;

    public PupilService(PupilRepo pupilRepository, MarksManager marksManager) {
        this.pupilRepository = pupilRepository;
        this.marksManager = marksManager;
    }



    @Override
    public PupilResponse add(PupilCreateRequest pupilCreateRequest) {
        Pupil pupil = new Pupil();
        FinalYearMarks marks = new FinalYearMarks();
        AllMarks weekMarks = new AllMarks();
        pupil.setFinalYearMarks(marks);
        pupil.setAllMarks(weekMarks);
        pupil.setCreatedDate(new Date(System.currentTimeMillis()));
        BeanUtils.copyProperties(pupilCreateRequest, pupil);
        Pupil savedPupil =  pupilRepository.save(pupil);
        PupilResponse response = new PupilResponse();
        BeanUtils.copyProperties(savedPupil,response);
        return response;
    }

    @Override
    public PupilResponse get(Long id) {
        Pupil pupil = pupilRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pupil not found"));
        PupilResponse response = new PupilResponse();
        BeanUtils.copyProperties(pupil, response);
        return response;
    }

    @Override
    public PupilResponse update(Long id, PupilUpdateRequest updateRequest) {
        Pupil pupil = pupilRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pupil not found"));
        BeanUtils.copyProperties(updateRequest, pupil);
        pupil.setUpdatedDate(new Date(System.currentTimeMillis()));
        Pupil updatedPupil = pupilRepository.save(pupil);
        PupilResponse response = new PupilResponse();
        BeanUtils.copyProperties(updatedPupil, response);
        return response;
    }

    @Override
    public void delete(Long id) {
        boolean exists = pupilRepository.existsById(id);
        if (!exists) {
            throw new NoSuchElementException("Pupil not found");
        }
        pupilRepository.deleteById(id);
    }



    public void setYearMark(Long id, PupilSetMarkRequest setMarkRequest){
        Subject subject = Subject.stringToEnum(setMarkRequest.getSubject());
        Pupil pupil = pupilRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pupil not found"));
        Double mark = marksManager.calcYearMark(pupil.getAllMarks(), subject);
        marksManager.initYearMark(pupil.getFinalYearMarks(), subject, mark);
        pupilRepository.save(pupil);
    }

    public void setMark(Long id, PupilSetMarkRequest setMarkRequest){
        Double mark = setMarkRequest.getMark();
        Subject subject = Subject.stringToEnum(setMarkRequest.getSubject());
        Pupil pupil = pupilRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pupil not found"));
        marksManager.initMark(pupil.getAllMarks(),subject,mark);
        pupilRepository.save(pupil);
    }

    public void setAllYearMarks(Long id){
        Pupil pupil = pupilRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pupil not found"));
        marksManager.initAllYearMarks(pupil.getFinalYearMarks(), pupil.getAllMarks());
        pupilRepository.save(pupil);
    }

    public List<Pupil> getAllPupils(){
        return pupilRepository.findAll();
    }
}
