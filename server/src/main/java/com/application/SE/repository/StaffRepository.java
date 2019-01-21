package com.application.SE.repository;
import com.application.SE.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "http;//localhost:4200")

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByStaffId(Long staffId);
    Staff findByStaffIds(String staffIds);
//    Staff findByStaffName(String staffName);
//    Staff findByJobtypeName(String jobtypeName);
//    Staff findByStaffJobtype(String staffJobtype);
//    Staff findByStaffStatus(String staffStatus);
//    Staff findByStaffSalary(int staffSalary);
//    Staff fingBySalary(int sa);
//    Staff findByStaffJobtype(String staffJobtype);
}
