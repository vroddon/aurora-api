package project.aurora.api.data;

import java.util.HashMap;
import java.util.Map;

public class GeneralData {
	
	public static Map<Long, Map<Long, Map<Long, Float>>> generalEnergyMap;
	static {
		generalEnergyMap = new HashMap<Long, Map<Long, Map<Long, Float>>>();
		generalEnergyMap.put((long) 1, Spain.energyMap);
		generalEnergyMap.put((long) 2, Portugal.energyMap);
		generalEnergyMap.put((long) 3, Slovenia.energyMap);
		generalEnergyMap.put((long) 4, Denmark.energyMap);
		generalEnergyMap.put((long) 5, England.energyMap);
		generalEnergyMap.put((long) 6, EU.energyMap);

	}
	
	public static Map<Long, Map<Long, Map<Long, Float>>> generalEmissionsMap;
	static {
		generalEmissionsMap = new HashMap<Long, Map<Long, Map<Long, Float>>>();
		generalEmissionsMap.put((long) 1, Spain.emissionsMap);
		generalEmissionsMap.put((long) 2, Portugal.emissionsMap);
		generalEmissionsMap.put((long) 3, Slovenia.emissionsMap);
		generalEmissionsMap.put((long) 4, Denmark.emissionsMap);
		generalEmissionsMap.put((long) 5, England.emissionsMap);
		generalEmissionsMap.put((long) 6, EU.emissionsMap);

	}
	
	public static Map<Long, Float> electricityEFMap;
	static {
		electricityEFMap = new HashMap<Long, Float>();
		electricityEFMap.put((long) 1, Spain.electricityEF);
		electricityEFMap.put((long) 2, Portugal.electricityEF);
		electricityEFMap.put((long) 3, Slovenia.electricityEF);
		electricityEFMap.put((long) 4, Denmark.electricityEF);
		electricityEFMap.put((long) 5, England.electricityEF);
		electricityEFMap.put((long) 6, EU.electricityEF);

	}
	
	public static Map<Long, Float> thermalEFMap;
	static {
		thermalEFMap = new HashMap<Long, Float>();
		thermalEFMap.put((long) 1, (float) 0.267);
		thermalEFMap.put((long) 2, (float) 0.202);
		thermalEFMap.put((long) 3, (float) 0.227);
		thermalEFMap.put((long) 4, (float) 0.231);
		thermalEFMap.put((long) 5, (float) 0.2878);
		thermalEFMap.put((long) 6, (float) 0.05);
		thermalEFMap.put((long) 7, (float) 0.0396);
		thermalEFMap.put((long) 8, (float) 0.26779);

	}

}
