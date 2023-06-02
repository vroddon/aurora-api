package project.aurora.api.data;

import java.util.HashMap;
import java.util.Map;

public class Portugal {

	/*
	 * 
	 * ELECTRICITY EF
	 * 
	 */
	
	public static float electricityEF = (float) 0.251;
	
	/*
	 * 
	 * ENERGY VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEnergy;
	static {
	    fuelCarEnergy = new HashMap<Long, Float>();
	    fuelCarEnergy.put((long) 1,(float) 0.6350);
	    fuelCarEnergy.put((long) 2,(float) 0.3335);
	    fuelCarEnergy.put((long) 3,(float) 0.2330);
	    fuelCarEnergy.put((long) 4,(float) 0.1827);
	    fuelCarEnergy.put((long) 5,(float) 0.1526);
	}
	
	public static Map<Long, Float> electricCarEnergy;
	static {
		electricCarEnergy = new HashMap<Long, Float>();
		electricCarEnergy.put((long)1,(float) 0.3082);
		electricCarEnergy.put((long)2,(float) 0.1571);
		electricCarEnergy.put((long)3,(float) 0.1067);
		electricCarEnergy.put((long)4,(float) 0.0815);
		electricCarEnergy.put((long)5,(float) 0.0664);

	}
	
	public static Map<Long, Float> hybridCarEnergy;
	static {
		hybridCarEnergy = new HashMap<Long, Float>();
		hybridCarEnergy.put((long)1,(float) 0.4047);
		hybridCarEnergy.put((long)2,(float) 0.2108);
		hybridCarEnergy.put((long)3,(float) 0.1462);
		hybridCarEnergy.put((long)4,(float) 0.1139);
		hybridCarEnergy.put((long)5,(float) 0.0945);

	}
	
	public static Map<Long, Float> motorcycleEnergy;
	static {
		motorcycleEnergy = new HashMap<Long, Float>();
		motorcycleEnergy.put((long)1,(float) 0.4152);
		motorcycleEnergy.put((long)2,(float) 0.2236);

	}
	
	public static Map<Long, Float> electricMotorcycleEnergy;
	static {
		electricMotorcycleEnergy = new HashMap<Long, Float>();
		electricMotorcycleEnergy.put((long)1,(float) 0.1247);
		electricMotorcycleEnergy.put((long)2,(float) 0.0624);

	}
	
	public static Map<Long, Float> electricBikeEnergy;
	static {
		electricBikeEnergy = new HashMap<Long, Float>();
		electricBikeEnergy.put((long)1,(float) 0.0112);

	}
	
	public static Map<Long, Float> electricScooterEnergy;
	static {
		electricScooterEnergy = new HashMap<Long, Float>();
		electricScooterEnergy.put((long)1,(float) 0.0243);

	}
	
	public static Map<Long, Float> busEnergy;
	static {
		busEnergy = new HashMap<Long, Float>();
		busEnergy.put((long)6,(float) 1.1862);
		busEnergy.put((long)7,(float) 0.3990);
		busEnergy.put((long)8,(float) 0.2502);

	}
	
	public static Map<Long, Float> metroTramEnergy;
	static {
		metroTramEnergy = new HashMap<Long, Float>();
		metroTramEnergy.put((long)6,(float) 0.1522);
		metroTramEnergy.put((long)7,(float) 0.0524);
		metroTramEnergy.put((long)8,(float) 0.0336);

	}
	
	public static Map<Long, Float> electricPassengerTrainEnergy;
	static {
		electricPassengerTrainEnergy = new HashMap<Long, Float>();
		electricPassengerTrainEnergy.put((long)6,(float) 0.2004);
		electricPassengerTrainEnergy.put((long)7,(float) 0.0678);
		electricPassengerTrainEnergy.put((long)8,(float) 0.0427);

	}
	
	public static Map<Long, Float> highSpeedTrainEnergy;
	static {
		highSpeedTrainEnergy = new HashMap<Long, Float>();
		highSpeedTrainEnergy.put((long)6,(float) 0.2630);
		highSpeedTrainEnergy.put((long)7,(float) 0.0877);
		highSpeedTrainEnergy.put((long)8,(float) 0.0546);

	}
	
	/*
	 * 
	 * EMISSIONS VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEmissions;
	static {
	    fuelCarEmissions = new HashMap<Long, Float>();
	    fuelCarEmissions.put((long) 1,(float) 0.1562);
	    fuelCarEmissions.put((long) 2,(float) 0.0547);
	    fuelCarEmissions.put((long) 3,(float) 0.0401);
	    fuelCarEmissions.put((long) 4,(float) 0.0329);
	    fuelCarEmissions.put((long) 5,(float) 0.0287);
	}
	
	public static Map<Long, Float> electricCarEmissions;
	static {
		electricCarEmissions = new HashMap<Long, Float>();
		electricCarEmissions.put((long)1,(float) 0.0619);
		electricCarEmissions.put((long)2,(float) 0.0100);
		electricCarEmissions.put((long)3,(float) 0.0070);
		electricCarEmissions.put((long)4,(float) 0.0055);
		electricCarEmissions.put((long)5,(float) 0.0046);

	}
	
	public static Map<Long, Float> hybridCarEmissions;
	static {
		hybridCarEmissions = new HashMap<Long, Float>();
		hybridCarEmissions.put((long)1,(float) 0.0904);
		hybridCarEmissions.put((long)2,(float) 0.0191);
		hybridCarEmissions.put((long)3,(float) 0.0132);
		hybridCarEmissions.put((long)4,(float) 0.0103);
		hybridCarEmissions.put((long)5,(float) 0.0086);

	}
	
	public static Map<Long, Float> motorcycleEmissions;
	static {
		motorcycleEmissions = new HashMap<Long, Float>();
		motorcycleEmissions.put((long)1,(float) 0.1021);
		motorcycleEmissions.put((long)2,(float) 0.0246);

	}
	
	public static Map<Long, Float> electricMotorcycleEmissions;
	static {
		electricMotorcycleEmissions = new HashMap<Long, Float>();
		electricMotorcycleEmissions.put((long)1,(float) 0.0251);
		electricMotorcycleEmissions.put((long)2,(float) 0.0017);

	}
	
	public static Map<Long, Float> electricBikeEmissions;
	static {
		electricBikeEmissions = new HashMap<Long, Float>();
		electricBikeEmissions.put((long)1,(float) 0.0023);

	}
	
	public static Map<Long, Float> electricScooterEmissions;
	static {
		electricScooterEmissions = new HashMap<Long, Float>();
		electricScooterEmissions.put((long)1,(float) 0.0049);

	}
	
	public static Map<Long, Float> busEmissions;
	static {
		busEmissions = new HashMap<Long, Float>();
		busEmissions.put((long)6,(float) 1.8504);
		busEmissions.put((long)7,(float) 0.6591);
		busEmissions.put((long)8,(float) 0.4362);

	}
	
	public static Map<Long, Float> metroTramEmissions;
	static {
		metroTramEmissions = new HashMap<Long, Float>();
		metroTramEmissions.put((long)6,(float) 0.1294);
		metroTramEmissions.put((long)7,(float) 0.0506);
		metroTramEmissions.put((long)8,(float) 0.0362);

	}
	
	public static Map<Long, Float> electricPassengerTrainEmissions;
	static {
		electricPassengerTrainEmissions = new HashMap<Long, Float>();
		electricPassengerTrainEmissions.put((long)6,(float) 0.3538);
		electricPassengerTrainEmissions.put((long)7,(float) 0.1319);
		electricPassengerTrainEmissions.put((long)8,(float) 0.0908);

	}
	
	public static Map<Long, Float> highSpeedTrainEmissions;
	static {
		highSpeedTrainEmissions = new HashMap<Long, Float>();
		highSpeedTrainEmissions.put((long)6,(float) 1.2522);
		highSpeedTrainEmissions.put((long)7,(float) 0.4502);
		highSpeedTrainEmissions.put((long)8,(float) 0.3004);

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
