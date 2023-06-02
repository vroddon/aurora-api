package project.aurora.api.data;

import java.util.HashMap;
import java.util.Map;

public class Denmark {
	
	/*
	 * 
	 * ELECTRICITY EF
	 * 
	 */
	
	public static float electricityEF = (float) 0.122;

	/*
	 * 
	 * ENERGY VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEnergy;
	static {
	    fuelCarEnergy = new HashMap<Long, Float>();
	    fuelCarEnergy.put((long) 1,(float) 0.773395);
	    fuelCarEnergy.put((long) 2,(float) 0.4026975);
	    fuelCarEnergy.put((long) 3,(float) 0.279131667);
	    fuelCarEnergy.put((long) 4,(float) 0.21734875);
	    fuelCarEnergy.put((long) 5,(float) 0.180279);
	}
	
	public static Map<Long, Float> electricCarEnergy;
	static {
		electricCarEnergy = new HashMap<Long, Float>();
		electricCarEnergy.put((long)1,(float) 0.3396);
		electricCarEnergy.put((long)2,(float) 0.1728);
		electricCarEnergy.put((long)3,(float) 0.1172);
		electricCarEnergy.put((long)4,(float) 0.0894);
		electricCarEnergy.put((long)5,(float) 0.0727);

	}
	
	public static Map<Long, Float> hybridCarEnergy;
	static {
		hybridCarEnergy = new HashMap<Long, Float>();
		hybridCarEnergy.put((long)1,(float) 0.6722);
		hybridCarEnergy.put((long)2,(float) 0.3446);
		hybridCarEnergy.put((long)3,(float) 0.2354);
		hybridCarEnergy.put((long)4,(float) 0.1808);
		hybridCarEnergy.put((long)5,(float) 0.1480);

	}
	
	public static Map<Long, Float> motorcycleEnergy;
	static {
		motorcycleEnergy = new HashMap<Long, Float>();
		motorcycleEnergy.put((long)1,(float) 0.4385);
		motorcycleEnergy.put((long)2,(float) 0.2352);

	}
	
	public static Map<Long, Float> electricMotorcycleEnergy;
	static {
		electricMotorcycleEnergy = new HashMap<Long, Float>();
		electricMotorcycleEnergy.put((long)1,(float) 0.419843);
		electricMotorcycleEnergy.put((long)2,(float) 0.2259215);

	}
	
	public static Map<Long, Float> electricBikeEnergy;
	static {
		electricBikeEnergy = new HashMap<Long, Float>();
		electricBikeEnergy.put((long)1,(float) 0.0123);

	}
	
	public static Map<Long, Float> electricScooterEnergy;
	static {
		electricScooterEnergy = new HashMap<Long, Float>();
		electricScooterEnergy.put((long)1,(float) 0.0268);

	}
	
	public static Map<Long, Float> busEnergy;
	static {
		busEnergy = new HashMap<Long, Float>();
		busEnergy.put((long)6,(float) 1.896629256);
		busEnergy.put((long)7,(float) 0.624952103);
		busEnergy.put((long)8,(float) 0.384528004);

	}
	
	public static Map<Long, Float> metroTramEnergy;
	static {
		metroTramEnergy = new HashMap<Long, Float>();
		metroTramEnergy.put((long)6,(float) 0.1791);
		metroTramEnergy.put((long)7,(float) 0.0610);
		metroTramEnergy.put((long)8,(float) 0.0387);

	}
	
	public static Map<Long, Float> electricPassengerTrainEnergy;
	static {
		electricPassengerTrainEnergy = new HashMap<Long, Float>();
		electricPassengerTrainEnergy.put((long)6,(float) 0.3253);
		electricPassengerTrainEnergy.put((long)7,(float) 0.1075);
		electricPassengerTrainEnergy.put((long)8,(float) 0.0663);

	}
	
	public static Map<Long, Float> highSpeedTrainEnergy;
	static {
		highSpeedTrainEnergy = new HashMap<Long, Float>();
		highSpeedTrainEnergy.put((long)6,(float) 0);
		highSpeedTrainEnergy.put((long)7,(float) 0);
		highSpeedTrainEnergy.put((long)8,(float) 0);

	}
	
	/*
	 * 
	 * EMISSIONS VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEmissions;
	static {
	    fuelCarEmissions = new HashMap<Long, Float>();
	    fuelCarEmissions.put((long) 1,(float) 0.18886);
	    fuelCarEmissions.put((long) 2,(float) 0.07927503);
	    fuelCarEmissions.put((long) 3,(float) 0.057182913);
	    fuelCarEmissions.put((long) 4,(float) 0.046264855);
	    fuelCarEmissions.put((long) 5,(float) 0.03981642);
	}
	
	public static Map<Long, Float> electricCarEmissions;
	static {
		electricCarEmissions = new HashMap<Long, Float>();
		electricCarEmissions.put((long)1,(float) 0.0394);
		electricCarEmissions.put((long)2,(float) 0.0071);
		electricCarEmissions.put((long)3,(float) 0.0051);
		electricCarEmissions.put((long)4,(float) 0.0040);
		electricCarEmissions.put((long)5,(float) 0.0034);

	}
	
	public static Map<Long, Float> hybridCarEmissions;
	static {
		hybridCarEmissions = new HashMap<Long, Float>();
		hybridCarEmissions.put((long)1,(float) 0.1211);
		hybridCarEmissions.put((long)2,(float) 0.0417);
		hybridCarEmissions.put((long)3,(float) 0.0285);
		hybridCarEmissions.put((long)4,(float) 0.0219);
		hybridCarEmissions.put((long)5,(float) 0.0179);

	}
	
	public static Map<Long, Float> motorcycleEmissions;
	static {
		motorcycleEmissions = new HashMap<Long, Float>();
		motorcycleEmissions.put((long)1,(float) 0.102524);
		motorcycleEmissions.put((long)2,(float) 0.024969748);

	}
	
	public static Map<Long, Float> electricMotorcycleEmissions;
	static {
		electricMotorcycleEmissions = new HashMap<Long, Float>();
		electricMotorcycleEmissions.put((long)1,(float) 0.0159);
		electricMotorcycleEmissions.put((long)2,(float) 0.0012);

	}
	
	public static Map<Long, Float> electricBikeEmissions;
	static {
		electricBikeEmissions = new HashMap<Long, Float>();
		electricBikeEmissions.put((long)1,(float) 0.0014);

	}
	
	public static Map<Long, Float> electricScooterEmissions;
	static {
		electricScooterEmissions = new HashMap<Long, Float>();
		electricScooterEmissions.put((long)1,(float) 0.0031);

	}
	
	public static Map<Long, Float> busEmissions;
	static {
		busEmissions = new HashMap<Long, Float>();
		busEmissions.put((long)6,(float) 2.923051324);
		busEmissions.put((long)7,(float) 0.998830949);
		busEmissions.put((long)8,(float) 0.636517573);

	}
	
	public static Map<Long, Float> metroTramEmissions;
	static {
		metroTramEmissions = new HashMap<Long, Float>();
		metroTramEmissions.put((long)6,(float) 0.0923);
		metroTramEmissions.put((long)7,(float) 0.0374);
		metroTramEmissions.put((long)8,(float) 0.0275);

	}
	
	public static Map<Long, Float> electricPassengerTrainEmissions;
	static {
		electricPassengerTrainEmissions = new HashMap<Long, Float>();
		electricPassengerTrainEmissions.put((long)6,(float) 0.4865);
		electricPassengerTrainEmissions.put((long)7,(float) 0.1781);
		electricPassengerTrainEmissions.put((long)8,(float) 0.1206);

	}
	
	public static Map<Long, Float> highSpeedTrainEmissions;
	static {
		highSpeedTrainEmissions = new HashMap<Long, Float>();
		highSpeedTrainEmissions.put((long)6,(float) 0);
		highSpeedTrainEmissions.put((long)7,(float) 0);
		highSpeedTrainEmissions.put((long)8,(float) 0);

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
