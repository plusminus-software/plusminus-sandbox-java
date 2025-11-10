package software.plusminus.sandbox.repository.fixtures;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TestEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String myField;

}
