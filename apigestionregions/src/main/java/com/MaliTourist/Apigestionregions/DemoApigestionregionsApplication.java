package com.MaliTourist.Apigestionregions;

import com.MaliTourist.Apigestionregions.Repository.PaysRepo;
import com.MaliTourist.Apigestionregions.Repository.PopulationRepo;
import com.MaliTourist.Apigestionregions.Repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApigestionregionsApplication{
	@Autowired
	private RegionRepo region;

	@Autowired
	private PaysRepo pays;

	@Autowired
	private PopulationRepo pop;

	public static void main(String[] args) {
		SpringApplication.run(DemoApigestionregionsApplication.class, args);
	}


}
