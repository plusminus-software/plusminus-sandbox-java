package software.plusminus.sandbox.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;
import software.plusminus.sandbox.repository.fixtures.TestEntity;
import software.plusminus.sandbox.repository.fixtures.TestRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCrudRepositoryContextTest {

    @Autowired
    private SpringCrudRepositoryContext service;

    @Test
    public void findCrudRepository() {
        CrudRepository<?, ?> repository = service.findCrudRepository(TestEntity.class);
        assertThat(repository).isNotNull()
                .isInstanceOf(TestRepository.class);
    }
}