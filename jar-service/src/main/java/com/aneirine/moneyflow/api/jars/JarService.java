package com.aneirine.moneyflow.api.jars;

import com.aneirine.moneyflow.api.jars.domain.JarData;
import com.aneirine.moneyflow.api.jars.domain.JarResponse;
import com.aneirine.moneyflow.entities.Jar;
import com.aneirine.moneyflow.entities.enums.JarStatus;
import com.aneirine.moneyflow.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JarService {

    private final JarRepository jarRepository;

    public JarService(JarRepository jarRepository) {
        this.jarRepository = jarRepository;
    }

    public JarResponse createJar(JarData data) {
        Jar jar = Jar.builder()
                .name(data.getName())
                .status(JarStatus.ACTIVE)
                .startDate(System.currentTimeMillis())
                .currentSum(0)
                .description(data.getDescription())
                .endDate(data.getEndDate())
                .goalSum(data.getGoalSum())
                .build();
        jarRepository.save(jar);
        return new JarResponse(jar);
    }

    public JarResponse getJarById(long id) {
        return new JarResponse(jarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("JAR_NOT_FOUND")));
    }

    public List<JarResponse> getJarsByIds(List<Long> list) {
        List<Jar> jars = jarRepository.findAllByIdIn(list);
        List<JarResponse> responses = jars.stream()
                .map(JarResponse::new)
                .collect(Collectors.toList());
        return responses;
    }

    public JarResponse updateJarById(JarData data, long id) {
        Jar jar = jarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("JAR_NOT_FOUND"));
        jar.setName(data.getName());
        jar.setDescription(data.getDescription());
        jar.setGoalSum(data.getGoalSum());
        jar.setEndDate(data.getEndDate());

        jarRepository.save(jar);
        return new JarResponse(jar);
    }

    public void deleteJarById(long id){
        jarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("JAR_NOT_FOUND"));
        jarRepository.deleteById(id);
    }


}
