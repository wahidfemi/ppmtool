package com.nseit.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nseit.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
    Iterable<Project> findAll();
	
	Project findByProjectIdentifier(String projectId);
}
