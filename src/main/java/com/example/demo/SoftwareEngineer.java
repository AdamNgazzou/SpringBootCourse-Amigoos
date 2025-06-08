package com.example.demo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SoftwareEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String techStack;
    @Column(columnDefinition = "TEXT")
    private String learningPathRecommandation;

    public SoftwareEngineer(Integer id, String name, String techStack) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
        this.learningPathRecommandation = learningPathRecommandation;

    }


    public SoftwareEngineer() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getLearningPathRecommandation() {
        return learningPathRecommandation;
    }

    public void setLearningPathRecommandation(String learningPathRecommandation) {
        this.learningPathRecommandation = learningPathRecommandation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(techStack, that.techStack) && Objects.equals(learningPathRecommandation, that.learningPathRecommandation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techStack, learningPathRecommandation);
    }
}
