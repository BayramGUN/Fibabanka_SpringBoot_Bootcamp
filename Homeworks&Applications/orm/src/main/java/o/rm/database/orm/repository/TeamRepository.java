package o.rm.database.orm.repository;

import o.rm.database.orm.Entity.relation.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {

}
