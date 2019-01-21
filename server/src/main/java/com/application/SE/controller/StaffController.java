package com.application.SE.controller;
import com.application.SE.Entity.*;
import com.application.SE.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;
import com.application.SE.Entity.Staff;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

class StaffController {
    @Autowired
    private final StaffRepository staffRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private JobtypeRepository jobtypeRepository;
    @Autowired
    private PayerRepository payerRepository;

    @Autowired
    StaffController(StaffRepository staffRepository,
                    PositionRepository positionRepository,
                    GenderRepository genderRepository,
                    EducationRepository educationRepository,
                    JobtypeRepository jobtypeRepository,
                    PayerRepository payerRepository
    ) {
        this.staffRepository = staffRepository;
        this.positionRepository = positionRepository;
        this.genderRepository = genderRepository;
        this.educationRepository = educationRepository;
        this.jobtypeRepository = jobtypeRepository;
        this.payerRepository = payerRepository;
    }

    @GetMapping("/staff")
    public Collection<Staff> staff() {
        return staffRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/education")
    public Collection<Education> education() {
        return educationRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/jobtype")
    public Collection<Jobtype> jobtype() {
        return jobtypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/position")
    public Collection<Position> position() {
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/gender")
    public Collection<Gender> gender() {
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/payer")
    public Collection<Payer> payer() {
        return payerRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/staffs/{staffName}/{genderid}/{educationId}/{staffPhone}/{jobtypeId}/{payerId}/{staffSalary}/{positionId}/{staffStatus}")
    public Staff newStaff(
            @PathVariable String staffName,
            @PathVariable Long genderid,
            @PathVariable Long educationId,
            @PathVariable String staffPhone,
            @PathVariable Long jobtypeId,
            @PathVariable Long payerId,
            @PathVariable int staffSalary,
            @PathVariable Long positionId,
            @PathVariable String staffStatus
    ) {
        Long i;
        Staff newStaff = new Staff();
        for( i=1L; i<9999L;i++) {
            if(staffRepository.findByStaffId(i) == null) {
                newStaff.setStaffIds("St"+i);
                break;
            }
        }

        Gender gender1 = genderRepository.findByGenderId(genderid);
        Jobtype jobtype1 = jobtypeRepository.findByJobtypeId(jobtypeId);
        Payer payer1 = payerRepository.findByPayerId(payerId);
        Education education1 = educationRepository.findByEducationId(educationId);
        Position position1 = positionRepository.findByPositionId(positionId);

        newStaff.setStaffName(staffName);
        newStaff.setGender(gender1);
        newStaff.setEducation(education1);
        newStaff.setStaffPhone(staffPhone);
        newStaff.setJobtype(jobtype1);
        newStaff.setPayer(payer1);
        newStaff.setStaffSalary(staffSalary);
        newStaff.setPosition(position1);
        newStaff.setStaffStatus(staffStatus);
        return staffRepository.save(newStaff);
    }


    @PutMapping("/staffs/{staffId}/{staffIds}/{staffName}/{staffSalary}/{jobtypeId}/{payerId}/{staffStatus}")
    public Staff newStaff2(
            Staff newStaff,
            @PathVariable Long staffId,
            @PathVariable String staffIds,
            @PathVariable String staffName,
            @PathVariable int staffSalary,
            @PathVariable Long jobtypeId,
            @PathVariable Long payerId,
            @PathVariable String staffStatus) {
        Jobtype jobtype = jobtypeRepository.findByJobtypeId(jobtypeId);
        Payer payer = payerRepository.findByPayerId(payerId);
        return staffRepository.findById(staffId)
                .map(staff -> {
                    staff.setStaffStatus(staffStatus);
                    staff.setPayer(payer);
                    staff.setJobtype(jobtype);
                            return staffRepository.save(staff);
                        }
                ).orElseGet(() -> {
                    newStaff.setStaffIds(staffIds);
                    newStaff.setStaffName(staffName);
                    newStaff.setStaffId(staffId);
                    newStaff.setStaffSalary(staffSalary);
                    return staffRepository.save(newStaff);
                });
    }
}



