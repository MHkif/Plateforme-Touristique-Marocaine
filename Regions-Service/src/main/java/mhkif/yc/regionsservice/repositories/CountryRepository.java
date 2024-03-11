package mhkif.yc.regionsservice.repositories;

import mhkif.yc.regionsservice.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
}
