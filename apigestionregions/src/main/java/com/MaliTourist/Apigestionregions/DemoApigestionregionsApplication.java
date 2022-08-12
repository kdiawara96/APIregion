package com.MaliTourist.Apigestionregions;

import com.MaliTourist.Apigestionregions.Repository.PaysRepo;
import com.MaliTourist.Apigestionregions.Repository.PopulationRepo;
import com.MaliTourist.Apigestionregions.Repository.RegionRepo;
import com.MaliTourist.Apigestionregions.modele.Pays;
import com.MaliTourist.Apigestionregions.modele.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApigestionregionsApplication implements CommandLineRunner {
	@Autowired
	private RegionRepo region;

	@Autowired
	private PaysRepo pays;

	@Autowired
	private PopulationRepo pop;

	public static void main(String[] args) {
		SpringApplication.run(DemoApigestionregionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		region.save(new Region(null,"R_01", "Kayes", "Culture de maïs", 2567, "Soninké"));
		pays.save(new Pays(null,"Mali"));

	}
}
