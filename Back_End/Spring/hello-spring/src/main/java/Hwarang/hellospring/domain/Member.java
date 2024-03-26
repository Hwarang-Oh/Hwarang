package Hwarang.hellospring.domain;

import jakarta.persistence.*;

@Entity // JPA가 관리한다는 것을 명시
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 ID를 생성해주는 전략 => Identity 전략
    private Long id;
    private String name;

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
}
