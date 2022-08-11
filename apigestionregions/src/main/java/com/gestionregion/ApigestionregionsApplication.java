package com.gestionregion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.gestionregion.apigestionregions.models.Pays;
import com.gestionregion.apigestionregions.models.Regions;
import com.gestionregion.apigestionregions.repositories.PaysRepository;
import com.gestionregion.apigestionregions.repositories.RegionRepository;


@SpringBootApplication

//  (exclude = (DataSourceAutoConfiguration.class))

public class ApigestionregionsApplication implements CommandLineRunner {
	
	
	@Autowired
	//(required=true)
     private	RegionRepository RegionsRepositories;
	 private PaysRepository PaysRepositories;

	public static void main(String[] args) {
		SpringApplication.run(ApigestionregionsApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		RegionsRepositories.save(new Regions(null,"ah_88","Bamako",25412,"service","Bambara"));
		PaysRepositories.save(new Pays(null,"MALI",1241238));
		
	 }

}
