package com.aneirine.jarservice.api.jars;

import com.aneirine.jarservice.api.feign.UserFeignService;
import com.aneirine.jarservice.api.jars.domain.JarData;
import com.aneirine.jarservice.api.jars.domain.JarResponse;
import com.aneirine.jarservice.entities.Jar;
import com.aneirine.jarservice.entities.enums.JarStatus;
import com.aneirine.jarservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JarService {

    private final JarRepository jarRepository;
    private final UserFeignService userFeignService;

    public JarService(JarRepository jarRepository, UserFeignService userFeignService) {
        this.jarRepository = jarRepository;
        this.userFeignService = userFeignService;
    }

    public JarResponse createJar(JarData data, long userId) {
        try {
            userFeignService.getUserById(userId);
        } catch (Exception e){
            throw new NotFoundException("USER_NOT_FOUND");
        }
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
        userFeignService.addJarToUser(userId, jar.getId());
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
