package in.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.ArEntity;

public interface ArRepo extends JpaRepository<ArEntity, Serializable>{

}
