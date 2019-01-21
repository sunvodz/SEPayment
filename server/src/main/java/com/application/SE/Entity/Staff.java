package com.application.SE.Entity;
        import javax.persistence.*;

        import lombok.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Staff")
public class Staff {

    @Id
    //@JsonFormat(pattern="yyyy-mm-dd")
    @SequenceGenerator(name="staff_seq",sequenceName="staff_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="staff_seq")
    @Column(name="staffId",unique = true, nullable = false)

    private @NonNull  Long staffId;
    private @NonNull String staffIds;
    private          String staffName;
    private @NonNull String staffPhone;
    private          int staffSalary;
    private          String staffStatus;
    private  String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "positionId", insertable = true)
    private Position position;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "genderId", insertable = true)
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Jobtype.class)
    @JoinColumn(name = "jobtypeId", insertable = true)
    private Jobtype jobtype;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Education.class)
    @JoinColumn(name = "educationId", insertable = true)
    private Education education;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Payer.class)
    @JoinColumn(name = "payerId", insertable = true)
    private Payer payer;


}