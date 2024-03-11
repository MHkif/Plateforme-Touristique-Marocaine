package mhkif.yc.regionsservice.config;

import lombok.RequiredArgsConstructor;
import mhkif.yc.regionsservice.entities.Country;
import mhkif.yc.regionsservice.entities.Region;
import mhkif.yc.regionsservice.repositories.CountryRepository;
import mhkif.yc.regionsservice.repositories.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Seeders implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    @Override
    public void run(String... args) throws Exception {

        createRegions(regionRepository, countryRepository);
    }


    private void createRegions(RegionRepository repository, CountryRepository countryRepository) {
        Country country = new Country();
        country.setName("MOROCCO");
        country.setWorld_number(212);

       Country savedCountry = countryRepository.save(country);

        Region region1 = new Region();
        region1.setName("Marrakech-Safi");
        region1.setCountry(savedCountry);
        region1.setCreatedAt(LocalDateTime.now());

        Region region2 = new Region();
        region2.setName("Tanger-Tétouan-Al Hoceïma");
        region2.setCountry(savedCountry);
        region2.setCreatedAt(LocalDateTime.now());


        var regions = List.of(
                region1, region2
        );

        repository.saveAll(regions);
    }

}
