package org.StudentManagementSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "student_details")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String Subject;
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(
                            name = "houseNo",
                            column = @Column(name = "current_house_no")
                    ),
                    @AttributeOverride(
                            name = "houseName",
                            column = @Column(name = "current_house_name")
                    ),
            }
    )
    private Address current_address;
    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(
                            name = "houseNo",
                            column = @Column(name = "permanent_house_no")
                    ),
                    @AttributeOverride(
                            name = "houseName",
                            column = @Column(name = "permanent_house_name")
                    ),
            }
    )
    private Address parmanent_address;
    @ElementCollection
    @CollectionTable(
            name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<String> skills;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", rollNo=" + rollNo +
                ", Subject='" + Subject + '\'' +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                ", deleted=" + deleted +
                '}';
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    private Boolean deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
