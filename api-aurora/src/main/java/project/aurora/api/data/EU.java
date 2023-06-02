package project.aurora.api.data;

import java.util.HashMap;
import java.util.Map;

public class EU {
	
	/*
	 * 
	 * ELECTRICITY EF
	 * 
	 */
	
	public static float electricityEF = (float) 0.252;

	/*
	 * 
	 * ENERGY VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEnergy;
	static {
	    fuelCarEnergy = new HashMap<Long, Float>();
	    fuelCarEnergy.put((long) 1,(float) 0.6931);
	    fuelCarEnergy.put((long) 2,(float) 0.3626);
	    fuelCarEnergy.put((long) 3,(float) 0.2524);
	    fuelCarEnergy.put((long) 4,(float) 0.1973);
	    fuelCarEnergy.put((long) 5,(float) 0.1642);
	}
	
	public static Map<Long, Float> electricCarEnergy;
	static {
		electricCarEnergy = new HashMap<Long, Float>();
		electricCarEnergy.put((long)1,(float) 0.3361);
		electricCarEnergy.put((long)2,(float) 0.1710);
		electricCarEnergy.put((long)3,(float) 0.1160);
		electricCarEnergy.put((long)4,(float) 0.0885);
		electricCarEnergy.put((long)5,(float) 0.0720);

	}
	
	public static Map<Long, Float> hybridCarEnergy;
	static {
		hybridCarEnergy = new HashMap<Long, Float>();
		hybridCarEnergy.put((long)1,(float) 0.4524);
		hybridCarEnergy.put((long)2,(float) 0.2347);
		hybridCarEnergy.put((long)3,(float) 0.1621);
		hybridCarEnergy.put((long)4,(float) 0.1258);
		hybridCarEnergy.put((long)5,(float) 0.1041);

	}
	
	public static Map<Long, Float> motorcycleEnergy;
	static {
		motorcycleEnergy = new HashMap<Long, Float>();
		motorcycleEnergy.put((long)1,(float) 0.4257);
		motorcycleEnergy.put((long)2,(float) 0.2288);

	}
	
	public static Map<Long, Float> electricMotorcycleEnergy;
	static {
		electricMotorcycleEnergy = new HashMap<Long, Float>();
		electricMotorcycleEnergy.put((long)1,(float) 0.1360);
		electricMotorcycleEnergy.put((long)2,(float) 0.0680);

	}
	
	public static Map<Long, Float> electricBikeEnergy;
	static {
		electricBikeEnergy = new HashMap<Long, Float>();
		electricBikeEnergy.put((long)1,(float) 0.0122);

	}
	
	public static Map<Long, Float> electricScooterEnergy;
	static {
		electricScooterEnergy = new HashMap<Long, Float>();
		electricScooterEnergy.put((long)1,(float) 0.0265);

	}
	
	public static Map<Long, Float> busEnergy;
	static {
		busEnergy = new HashMap<Long, Float>();
		busEnergy.put((long)6,(float) 1.0221);
		busEnergy.put((long)7,(float) 0.3468);
		busEnergy.put((long)8,(float) 0.2192);

	}
	
	public static Map<Long, Float> metroTramEnergy;
	static {
		metroTramEnergy = new HashMap<Long, Float>();
		metroTramEnergy.put((long)6,(float) 0.2015);
		metroTramEnergy.put((long)7,(float) 0.0681);
		metroTramEnergy.put((long)8,(float) 0.0429);

	}
	
	public static Map<Long, Float> electricPassengerTrainEnergy;
	static {
		electricPassengerTrainEnergy = new HashMap<Long, Float>();
		electricPassengerTrainEnergy.put((long)6,(float) 0.4534);
		electricPassengerTrainEnergy.put((long)7,(float) 0.1482);
		electricPassengerTrainEnergy.put((long)8,(float) 0.0905);

	}
	
	public static Map<Long, Float> highSpeedTrainEnergy;
	static {
		highSpeedTrainEnergy = new HashMap<Long, Float>();
		highSpeedTrainEnergy.put((long)6,(float) 0.2797);
		highSpeedTrainEnergy.put((long)7,(float) 0.0930);
		highSpeedTrainEnergy.put((long)8,(float) 0.0577);

	}
	
	/*
	 * 
	 * EMISSIONS VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEmissions;
	static {
	    fuelCarEmissions = new HashMap<Long, Float>();
	    fuelCarEmissions.put((long) 1,(float) 0.1722);
	    fuelCarEmissions.put((long) 2,(float) 0.0654);
	    fuelCarEmissions.put((long) 3,(float) 0.0475);
	    fuelCarEmissions.put((long) 4,(float) 0.0387);
	    fuelCarEmissions.put((long) 5,(float) 0.0335);
	}
	
	public static Map<Long, Float> electricCarEmissions;
	static {
		electricCarEmissions = new HashMap<Long, Float>();
		electricCarEmissions.put((long)1,(float) 0.0760);
		electricCarEmissions.put((long)2,(float) 0.0133);
		electricCarEmissions.put((long)3,(float) 0.0093);
		electricCarEmissions.put((long)4,(float) 0.0072);
		electricCarEmissions.put((long)5,(float) 0.0060);

	}
	
	public static Map<Long, Float> hybridCarEmissions;
	static {
		hybridCarEmissions = new HashMap<Long, Float>();
		hybridCarEmissions.put((long)1,(float) 0.1073);
		hybridCarEmissions.put((long)2,(float) 0.0252);
		hybridCarEmissions.put((long)3,(float) 0.0174);
		hybridCarEmissions.put((long)4,(float) 0.0135);
		hybridCarEmissions.put((long)5,(float) 0.0112);

	}
	
	public static Map<Long, Float> motorcycleEmissions;
	static {
		motorcycleEmissions = new HashMap<Long, Float>();
		motorcycleEmissions.put((long)1,(float) 0.1058);
		motorcycleEmissions.put((long)2,(float) 0.0260);

	}
	
	public static Map<Long, Float> electricMotorcycleEmissions;
	static {
		electricMotorcycleEmissions = new HashMap<Long, Float>();
		electricMotorcycleEmissions.put((long)1,(float) 0.0307);
		electricMotorcycleEmissions.put((long)2,(float) 0.0022);

	}
	
	public static Map<Long, Float> electricBikeEmissions;
	static {
		electricBikeEmissions = new HashMap<Long, Float>();
		electricBikeEmissions.put((long)1,(float) 0.0028);

	}
	
	public static Map<Long, Float> electricScooterEmissions;
	static {
		electricScooterEmissions = new HashMap<Long, Float>();
		electricScooterEmissions.put((long)1,(float) 0.0060);

	}
	
	public static Map<Long, Float> busEmissions;
	static {
		busEmissions = new HashMap<Long, Float>();
		busEmissions.put((long)6,(float) 1.5926);
		busEmissions.put((long)7,(float) 0.5770);
		busEmissions.put((long)8,(float) 0.3877);

	}
	
	public static Map<Long, Float> metroTramEmissions;
	static {
		metroTramEmissions = new HashMap<Long, Float>();
		metroTramEmissions.put((long)6,(float) 0.2252);
		metroTramEmissions.put((long)7,(float) 0.0831);
		metroTramEmissions.put((long)8,(float) 0.0567);

	}
	
	public static Map<Long, Float> electricPassengerTrainEmissions;
	static {
		electricPassengerTrainEmissions = new HashMap<Long, Float>();
		electricPassengerTrainEmissions.put((long)6,(float) 1.6363);
		electricPassengerTrainEmissions.put((long)7,(float) 0.5568);
		electricPassengerTrainEmissions.put((long)8,(float) 0.3534);

	}
	
	public static Map<Long, Float> highSpeedTrainEmissions;
	static {
		highSpeedTrainEmissions = new HashMap<Long, Float>();
		highSpeedTrainEmissions.put((long)6,(float) 1.6062);
		highSpeedTrainEmissions.put((long)7,(float) 0.5692);
		highSpeedTrainEmissions.put((long)8,(float) 0.3750);

	}
	
	/*
	 * 
	 * GENERAL VALUES
	 * 
	 */
	
	public static Map<Long, Map<Long, Float>> energyMap;
	static {
		energyMap = new HashMap<Long, Map<Long, Float>>();
		energyMap.put((long) 1,fuelCarEnergy);
		energyMap.put((long) 2,electricCarEnergy);
		energyMap.put((long) 3,hybridCarEnergy);
		energyMap.put((long) 4,motorcycleEnergy);
		energyMap.put((long) 5,electricMotorcycleEnergy);
		energyMap.put((long) 6,electricBikeEnergy);
		energyMap.put((long) 7,electricScooterEnergy);
		energyMap.put((long) 8,busEnergy);
		energyMap.put((long) 9,metroTramEnergy);
		energyMap.put((long) 10,electricPassengerTrainEnergy);
		energyMap.put((long) 11,highSpeedTrainEnergy);
	}
	
	public static Map<Long, Map<Long, Float>> emissionsMap;
	static {
		emissionsMap = new HashMap<Long, Map<Long, Float>>();
		emissionsMap.put((long) 1,fuelCarEmissions);
		emissionsMap.put((long) 2,electricCarEmissions);
		emissionsMap.put((long) 3,hybridCarEmissions);
		emissionsMap.put((long) 4,motorcycleEmissions);
		emissionsMap.put((long) 5,electricMotorcycleEmissions);
		emissionsMap.put((long) 6,electricBikeEmissions);
		emissionsMap.put((long) 7,electricScooterEmissions);
		emissionsMap.put((long) 8,busEmissions);
		emissionsMap.put((long) 9,metroTramEmissions);
		emissionsMap.put((long) 10,electricPassengerTrainEmissions);
		emissionsMap.put((long) 11,highSpeedTrainEmissions);
	}
}
