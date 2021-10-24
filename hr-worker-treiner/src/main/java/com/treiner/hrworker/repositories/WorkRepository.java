package com.treiner.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treiner.hrworker.entities.Work;

public interface WorkRepository  extends JpaRepository<Work, Long>{

}
