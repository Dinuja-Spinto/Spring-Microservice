package com.Langstroth.schoolservice.service;

import com.Langstroth.schoolservice.entity.School;
import com.Langstroth.schoolservice.repository.SchoolRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> fetchSchools() {
        return schoolRepository.findAll();
    }

    public School fetchSchoolById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public School updateSchool(School school) {
        School upScl = schoolRepository.findById(school.getId()).orElse(null);
        if (StringUtils.isNotEmpty(school.getSchoolName())) {
            upScl.setSchoolName(school.getSchoolName());
        }
        if (StringUtils.isNotEmpty(school.getLocation())) {
            upScl.setLocation(school.getLocation());
        }
        if (StringUtils.isNotEmpty(school.getPrincipalName())) {
            upScl.setPrincipalName(school.getPrincipalName());
        }
        return schoolRepository.save(upScl);
    }
}
