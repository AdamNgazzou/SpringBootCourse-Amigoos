package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AiService aiService;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository,
                                   AiService aiService) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }


    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }


    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        String prompt = """
                Based on the programming test stack %s that %s has given
                Provide a full learning path and recommandation for this person. 
                """.formatted(softwareEngineer.getTechStack(), softwareEngineer.getName());
        String chatRes = aiService.chat(prompt);
        softwareEngineer.setLearningPathRecommandation(chatRes);
        softwareEngineerRepository.save(softwareEngineer);


    }

    public SoftwareEngineer getSoftwareEngineerById(int id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public void deleteSoftwareEngineerById(int id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    id + " not found"
            );
        }
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id,
                                       SoftwareEngineer update) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + " not found"));
        softwareEngineer.setName(update.getName());
        softwareEngineer.setTechStack(update.getTechStack());
            softwareEngineerRepository.save(softwareEngineer);
    }

}
