package com.aneirine.jarservice.api.jars;

import com.aneirine.jarservice.api.jars.domain.JarData;
import com.aneirine.jarservice.api.jars.domain.JarResponse;
import com.aneirine.jarservice.entities.Jar;
import com.aneirine.jarservice.entities.enums.JarStatus;
import com.aneirine.jarservice.exceptions.ConflictException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class JarService {

    private final JarRepository jarRepository;

    public JarService(JarRepository jarRepository) {
        this.jarRepository = jarRepository;
    }

    public JarResponse createJar(JarData data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate, endDate;
        try {
            startDate = formatter.parse(data.getStartDate());
            endDate = formatter.parse(data.getEndDate());
        } catch (ParseException e) {
            throw new ConflictException("DATE_PARSE_ERROR");
        }
        Jar jar = new Jar(
                data.getAim(), startDate, endDate, JarStatus.ACTIVE, data.getDescription(), data.getSumGoal(), 0
        );
        jarRepository.save(jar);
        return new JarResponse(jar);
    }
}
