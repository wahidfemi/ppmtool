package com.nseit.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nseit.ppmtool.domain.Project;
import com.nseit.ppmtool.exceptions.ProjectIdException;
import com.nseit.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {
     
	 @Autowired
     private ProjectRepository projectRepository;
	 
	 public Project saveOrUpdateProject(Project project){
		 //logic
		 try {
			 project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			 return projectRepository.save(project);
		 }
		 catch(Exception e) {
			 throw new ProjectIdException("Project ID : "+project.getProjectIdentifier().toUpperCase()+" is already exists.");
		 }
	 }
	 
	 public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID '"+projectId+"' does not exist");
        }
        return project;
	 }
	 
	 public Iterable<Project> findAllProjects(){
	    return projectRepository.findAll();
	 }
}
