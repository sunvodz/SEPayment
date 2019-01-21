package com.application.SE.repository;
import com.application.SE.Entity.*;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http;//localhost:4200")

public interface PayerRepository extends JpaRepository<Payer, Long> {
        Payer findByPayerId(Long id);
//        Payer findByPayerIds(String payerIds);
        Payer findByPayerName(String payerName);
}
