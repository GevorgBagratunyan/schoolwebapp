package com.gevbagratunyan.school.service.services;

import com.gevbagratunyan.school.entity.data.PupilYearMarks;
import com.gevbagratunyan.school.entity.enums.Subject;
import com.gevbagratunyan.school.entity.models.Pupil;
import com.gevbagratunyan.school.repository.MarksRepo;
import com.gevbagratunyan.school.repository.PupilRepo;
import com.gevbagratunyan.school.service.crud.CreateSupported;
import com.gevbagratunyan.school.service.crud.DeleteSupported;
import com.gevbagratunyan.school.service.crud.ReadSupported;
import com.gevbagratunyan.school.service.crud.UpdateSupported;
import com.gevbagratunyan.school.transfer.admin.request.AdminPupilCreateRequest;
import com.gevbagratunyan.school.transfer.admin.request.AdminPupilSetMarkRequest;
import com.gevbagratunyan.school.transfer.admin.request.AdminPupilUpdateRequest;
import com.gevbagratunyan.school.transfer.pupil.PupilResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PupilService implements CreateSupported<AdminPupilCreateRequest,
        PupilResponse>, ReadSupported<Long, PupilResponse>,
        UpdateSupported<Long, AdminPupilUpdateRequest, PupilResponse>,
        DeleteSupported<Long> {

    private final PupilRepo pupilRepository;
    private final MarksRepo marksRepo;

    public PupilService(PupilRepo pupilRepository, MarksRepo marksRepo) {
        this.pupilRepository = pupilRepository;
        this.marksRepo = marksRepo;
    }



    @Override
    public PupilResponse add(AdminPupilCreateRequest adminPupilCreateRequest) {
        Pupil pupil = new Pupil();
        PupilYearMarks marks = new PupilYearMarks();
        marks.setIdCard(adminPupilCreateRequest.getIdCard());
        pupil.setPupilYearMarks(marks);
        pupil.setCreatedDate(new Date(System.currentTimeMillis()));
        BeanUtils.copyProperties(adminPupilCreateRequest, pupil);
        marksRepo.save(marks);
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
    public PupilResponse update(Long id, AdminPupilUpdateRequest updateRequest) {
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



    public void setYearMark(Long id, AdminPupilSetMarkRequest markRequest){
        Subject subject = Subject.stringToEnum(markRequest.getSubject());
        byte mark=markRequest.getMark();
        Pupil pupil = pupilRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pupil not found"));
        switch(subject){
            case MATH:
                pupil.getPupilYearMarks().setMATH(mark);
                break;
            case ENG:
                pupil.getPupilYearMarks().setENG(mark);
                break;
            case RUS:
                pupil.getPupilYearMarks().setRUS(mark);
                break;
            case ARM:
                pupil.getPupilYearMarks().setARM(mark);
                break;
            case CHEM:
                pupil.getPupilYearMarks().setCHEM(mark);
                break;
            case PHYS:
                pupil.getPupilYearMarks().setPHYS(mark);
                break;
            case GEOM:
                pupil.getPupilYearMarks().setGEOM(mark);
                break;
            case GEOG:
                pupil.getPupilYearMarks().setGEOG(mark);
                break;
            case BIOL:
                pupil.getPupilYearMarks().setBIOL(mark);
                break;
            case HIST:
                pupil.getPupilYearMarks().setHIST(mark);
                break;
            case ARM_HIST:
                pupil.getPupilYearMarks().setARM_HIST(mark);
                break;
            default: throw new IllegalArgumentException();
        }
        pupil.getPupilYearMarks().initMarks();
        marksRepo.save(pupil.getPupilYearMarks());
    }

    public List<Pupil> getAllPupils(){
        return pupilRepository.findAll();
    }
}
