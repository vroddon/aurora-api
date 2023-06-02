package project.aurora.api.data;

import java.util.HashMap;
import java.util.Map;

public class England {

	/*
	 * 
	 * ELECTRICITY EF
	 * 
	 */
	
	public static float electricityEF = (float) 0.228;
	
	/*
	 * 
	 * ENERGY VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEnergy;
	static {
	    fuelCarEnergy = new HashMap<Long, Float>();
	    fuelCarEnergy.put((long) 1,(float) 0.7036);
	    fuelCarEnergy.put((long) 2,(float) 0.3678);
	    fuelCarEnergy.put((long) 3,(float) 0.2559);
	    fuelCarEnergy.put((long) 4,(float) 0.1999);
	    fuelCarEnergy.put((long) 5,(float) 0.1663);
	}
	
	public static Map<Long, Float> electricCarEnergy;
	static {
		electricCarEnergy = new HashMap<Long, Float>();
		electricCarEnergy.put((long)1,(float) 0.3524);
		electricCarEnergy.put((long)2,(float) 0.1792);
		electricCarEnergy.put((long)3,(float) 0.1214);
		electricCarEnergy.put((long)4,(float) 0.0926);
		electricCarEnergy.put((long)5,(float) 0.0752);

	}
	
	public static Map<Long, Float> hybridCarEnergy;
	static {
		hybridCarEnergy = new HashMap<Long, Float>();
		hybridCarEnergy.put((long)1,(float) 0.4012);
		hybridCarEnergy.put((long)2,(float) 0.2091);
		hybridCarEnergy.put((long)3,(float) 0.1451);
		hybridCarEnergy.put((long)4,(float) 0.1130);
		hybridCarEnergy.put((long)5,(float) 0.0938);

	}
	
	public static Map<Long, Float> motorcycleEnergy;
	static {
		motorcycleEnergy = new HashMap<Long, Float>();
		motorcycleEnergy.put((long)1,(float) 0.4559);
		motorcycleEnergy.put((long)2,(float) 0.2439);

	}
	
	public static Map<Long, Float> electricMotorcycleEnergy;
	static {
		electricMotorcycleEnergy = new HashMap<Long, Float>();
		electricMotorcycleEnergy.put((long)1,(float) 0.1426);
		electricMotorcycleEnergy.put((long)2,(float) 0.0713);

	}
	
	public static Map<Long, Float> electricBikeEnergy;
	static {
		electricBikeEnergy = new HashMap<Long, Float>();
		electricBikeEnergy.put((long)1,(float) 0.0128);

	}
	
	public static Map<Long, Float> electricScooterEnergy;
	static {
		electricScooterEnergy = new HashMap<Long, Float>();
		electricScooterEnergy.put((long)1,(float) 0.0278);

	}
	
	public static Map<Long, Float> busEnergy;
	static {
		busEnergy = new HashMap<Long, Float>();
		busEnergy.put((long)6,(float) 1.0507);
		busEnergy.put((long)7,(float) 0.3559);
		busEnergy.put((long)8,(float) 0.2246);

	}
	
	public static Map<Long, Float> metroTramEnergy;
	static {
		metroTramEnergy = new HashMap<Long, Float>();
		metroTramEnergy.put((long)6,(float) 0.2346);
		metroTramEnergy.put((long)7,(float) 0.0787);
		metroTramEnergy.put((long)8,(float) 0.0492);

	}
	
	public static Map<Long, Float> electricPassengerTrainEnergy;
	static {
		electricPassengerTrainEnergy = new HashMap<Long, Float>();
		electricPassengerTrainEnergy.put((long)6,(float) 0.3879);
		electricPassengerTrainEnergy.put((long)7,(float) 0.1274);
		electricPassengerTrainEnergy.put((long)8,(float) 0.0782);

	}
	
	public static Map<Long, Float> highSpeedTrainEnergy;
	static {
		highSpeedTrainEnergy = new HashMap<Long, Float>();
		highSpeedTrainEnergy.put((long)6,(float) 0.2703);
		highSpeedTrainEnergy.put((long)7,(float) 0.0900);
		highSpeedTrainEnergy.put((long)8,(float) 0.0559);

	}
	
	/*
	 * 
	 * EMISSIONS VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEmissions;
	static {
	    fuelCarEmissions = new HashMap<Long, Float>();
	    fuelCarEmissions.put((long) 1,(float) 0.1791);
	    fuelCarEmissions.put((long) 2,(float) 0.0688);
	    fuelCarEmissions.put((long) 3,(float) 0.0499);
	    fuelCarEmissions.put((long) 4,(float) 0.0406);
	    fuelCarEmissions.put((long) 5,(float) 0.0351);
	}
	
	public static Map<Long, Float> electricCarEmissions;
	static {
		electricCarEmissions = new HashMap<Long, Float>();
		electricCarEmissions.put((long)1,(float) 0.0736);
		electricCarEmissions.put((long)2,(float) 0.0135);
		electricCarEmissions.put((long)3,(float) 0.0094);
		electricCarEmissions.put((long)4,(float) 0.0074);
		electricCarEmissions.put((long)5,(float) 0.0061);

	}
	
	public static Map<Long, Float> hybridCarEmissions;
	static {
		hybridCarEmissions = new HashMap<Long, Float>();
		hybridCarEmissions.put((long)1,(float) 0.0930);
		hybridCarEmissions.put((long)2,(float) 0.0195);
		hybridCarEmissions.put((long)3,(float) 0.0135);
		hybridCarEmissions.put((long)4,(float) 0.0105);
		hybridCarEmissions.put((long)5,(float) 0.0087);

	}
	
	public static Map<Long, Float> motorcycleEmissions;
	static {
		motorcycleEmissions = new HashMap<Long, Float>();
		motorcycleEmissions.put((long)1,(float) 0.1160);
		motorcycleEmissions.put((long)2,(float) 0.0303);

	}
	
	public static Map<Long, Float> electricMotorcycleEmissions;
	static {
		electricMotorcycleEmissions = new HashMap<Long, Float>();
		electricMotorcycleEmissions.put((long)1,(float) 0.0298);
		electricMotorcycleEmissions.put((long)2,(float) 0.0023);

	}
	
	public static Map<Long, Float> electricBikeEmissions;
	static {
		electricBikeEmissions = new HashMap<Long, Float>();
		electricBikeEmissions.put((long)1,(float) 0.0027);

	}
	
	public static Map<Long, Float> electricScooterEmissions;
	static {
		electricScooterEmissions = new HashMap<Long, Float>();
		electricScooterEmissions.put((long)1,(float) 0.0058);

	}
	
	public static Map<Long, Float> busEmissions;
	static {
		busEmissions = new HashMap<Long, Float>();
		busEmissions.put((long)6,(float) 1.6930);
		busEmissions.put((long)7,(float) 0.6104);
		busEmissions.put((long)8,(float) 0.4084);

	}
	
	public static Map<Long, Float> metroTramEmissions;
	static {
		metroTramEmissions = new HashMap<Long, Float>();
		metroTramEmissions.put((long)6,(float) 0.3009);
		metroTramEmissions.put((long)7,(float) 0.1094);
		metroTramEmissions.put((long)8,(float) 0.0737);

	}
	
	public static Map<Long, Float> electricPassengerTrainEmissions;
	static {
		electricPassengerTrainEmissions = new HashMap<Long, Float>();
		electricPassengerTrainEmissions.put((long)6,(float) 1.2714);
		electricPassengerTrainEmissions.put((long)7,(float) 0.4391);
		electricPassengerTrainEmissions.put((long)8,(float) 0.2825);

	}
	
	public static Map<Long, Float> highSpeedTrainEmissions;
	static {
		highSpeedTrainEmissions = new HashMap<Long, Float>();
		highSpeedTrainEmissions.put((long)6,(float) 1.7179);
		highSpeedTrainEmissions.put((long)7,(float) 0.6141);
		highSpeedTrainEmissions.put((long)8,(float) 0.3387);

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
