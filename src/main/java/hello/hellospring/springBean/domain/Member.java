package hello.hellospring.springBean.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * packageName    : hello.hellospring.springBean.domain
 * fileName       : SpringBeanMember
 * author         : asdfz
 * date           : 2023-06-13
 * description    : 자바로 스프링 빈 생성을 위한 파일
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-13        asdfz       최초 생성
 */
@Entity
public class Member {

    //DB가 생성해주는 거를 IDENTITY로 함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
