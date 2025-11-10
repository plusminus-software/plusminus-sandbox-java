package software.plusminus.sandbox.repository;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@SuppressWarnings("squid:S00119")
@Service
public class SpringCrudRepositoryContext implements CrudRepositoryContext {

    private Repositories repositories;

    public SpringCrudRepositoryContext(ListableBeanFactory listableBeanFactory) {
        repositories = new Repositories(listableBeanFactory);
    }

    @Override
    public <T, ID> CrudRepository<T, ID> findCrudRepository(Class<T> type) {
        return repositories.getRepositoryFor(type)
                .filter(CrudRepository.class::isInstance)
                .map(repository -> (CrudRepository<T, ID>) repository)
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public <ID> Class<ID> getIdType(String type) {
        return repositories.getRepositoryInformationFor(getType(type))
                .map(RepositoryInformation::getIdType)
                .map(c -> (Class<ID>) c)
                .orElseThrow(IllegalStateException::new);
    }

    private <T> Class<T> getType(String type) {
        return StreamSupport.stream(repositories.spliterator(), false)
                .filter(c -> c.getSimpleName().equals(type))
                .findFirst()
                .map(c -> (Class<T>) c)
                .orElseThrow(IllegalStateException::new);
    }
}