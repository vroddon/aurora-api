package project.aurora.api.data;

import java.util.HashMap;
import java.util.Map;

public class Slovenia {
	
	/*
	 * 
	 * ELECTRICITY EF
	 * 
	 */
	
	public static float electricityEF = (float) 0.242;

	/*
	 * 
	 * ENERGY VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEnergy;
	static {
	    fuelCarEnergy = new HashMap<Long, Float>();
	    fuelCarEnergy.put((long) 1,(float) 0.7292);
	    fuelCarEnergy.put((long) 2,(float) 0.3806);
	    fuelCarEnergy.put((long) 3,(float) 0.2644);
	    fuelCarEnergy.put((long) 4,(float) 0.2063);
	    fuelCarEnergy.put((long) 5,(float) 0.1714);
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
		hybridCarEnergy.put((long)1,(float) 0.3733);
		hybridCarEnergy.put((long)2,(float) 0.1951);
		hybridCarEnergy.put((long)3,(float) 0.1358);
		hybridCarEnergy.put((long)4,(float) 0.1061);
		hybridCarEnergy.put((long)5,(float) 0.0882);

	}
	
	public static Map<Long, Float> motorcycleEnergy;
	static {
		motorcycleEnergy = new HashMap<Long, Float>();
		motorcycleEnergy.put((long)1,(float) 0.4373);
		motorcycleEnergy.put((long)2,(float) 0.2346);

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
		busEnergy.put((long)6,(float) 0.7135);
		busEnergy.put((long)7,(float) 0.2487);
		busEnergy.put((long)8,(float) 0.1608);

	}
	
	public static Map<Long, Float> metroTramEnergy;
	static {
		metroTramEnergy = new HashMap<Long, Float>();
		metroTramEnergy.put((long)6,(float) 0);
		metroTramEnergy.put((long)7,(float) 0);
		metroTramEnergy.put((long)8,(float) 0);

	}
	
	public static Map<Long, Float> electricPassengerTrainEnergy;
	static {
		electricPassengerTrainEnergy = new HashMap<Long, Float>();
		electricPassengerTrainEnergy.put((long)6,(float) 0.5350);
		electricPassengerTrainEnergy.put((long)7,(float) 0.1742);
		electricPassengerTrainEnergy.put((long)8,(float) 0.1060);

	}
	
	public static Map<Long, Float> highSpeedTrainEnergy;
	static {
		highSpeedTrainEnergy = new HashMap<Long, Float>();
		highSpeedTrainEnergy.put((long)6,(float) 0.3572);
		highSpeedTrainEnergy.put((long)7,(float) 0.1176);
		highSpeedTrainEnergy.put((long)8,(float) 0.0724);

	}
	
	/*
	 * 
	 * EMISSIONS VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEmissions;
	static {
	    fuelCarEmissions = new HashMap<Long, Float>();
	    fuelCarEmissions.put((long) 1,(float) 0.1875);
	    fuelCarEmissions.put((long) 2,(float) 0.0744);
	    fuelCarEmissions.put((long) 3,(float) 0.0538);
	    fuelCarEmissions.put((long) 4,(float) 0.0436);
	    fuelCarEmissions.put((long) 5,(float) 0.0376);
	}
	
	public static Map<Long, Float> electricCarEmissions;
	static {
		electricCarEmissions = new HashMap<Long, Float>();
		electricCarEmissions.put((long)1,(float) 0.0772);
		electricCarEmissions.put((long)2,(float) 0.0397);
		electricCarEmissions.put((long)3,(float) 0.0272);
		electricCarEmissions.put((long)4,(float) 0.0209);
		electricCarEmissions.put((long)5,(float) 0.0171);

	}
	
	public static Map<Long, Float> hybridCarEmissions;
	static {
		hybridCarEmissions = new HashMap<Long, Float>();
		hybridCarEmissions.put((long)1,(float) 0.0889);
		hybridCarEmissions.put((long)2,(float) 0.0174);
		hybridCarEmissions.put((long)3,(float) 0.0121);
		hybridCarEmissions.put((long)4,(float) 0.0094);
		hybridCarEmissions.put((long)5,(float) 0.0079);

	}
	
	public static Map<Long, Float> motorcycleEmissions;
	static {
		motorcycleEmissions = new HashMap<Long, Float>();
		motorcycleEmissions.put((long)1,(float) 0.1124);
		motorcycleEmissions.put((long)2,(float) 0.0603);

	}
	
	public static Map<Long, Float> electricMotorcycleEmissions;
	static {
		electricMotorcycleEmissions = new HashMap<Long, Float>();
		electricMotorcycleEmissions.put((long)1,(float) 0.0312);
		electricMotorcycleEmissions.put((long)2,(float) 0.0024);

	}
	
	public static Map<Long, Float> electricBikeEmissions;
	static {
		electricBikeEmissions = new HashMap<Long, Float>();
		electricBikeEmissions.put((long)1,(float) 0.0028);

	}
	
	public static Map<Long, Float> electricScooterEmissions;
	static {
		electricScooterEmissions = new HashMap<Long, Float>();
		electricScooterEmissions.put((long)1,(float) 0.0061);

	}
	
	public static Map<Long, Float> busEmissions;
	static {
		busEmissions = new HashMap<Long, Float>();
		busEmissions.put((long)6,(float) 1.1839);
		busEmissions.put((long)7,(float) 0.4513);
		busEmissions.put((long)8,(float) 0.3169);

	}
	
	public static Map<Long, Float> metroTramEmissions;
	static {
		metroTramEmissions = new HashMap<Long, Float>();
		metroTramEmissions.put((long)6,(float) 0);
		metroTramEmissions.put((long)7,(float) 0);
		metroTramEmissions.put((long)8,(float) 0);

	}
	
	public static Map<Long, Float> electricPassengerTrainEmissions;
	static {
		electricPassengerTrainEmissions = new HashMap<Long, Float>();
		electricPassengerTrainEmissions.put((long)6,(float) 1.1626);
		electricPassengerTrainEmissions.put((long)7,(float) 0.3920);
		electricPassengerTrainEmissions.put((long)8,(float) 0.2467);

	}
	
	public static Map<Long, Float> highSpeedTrainEmissions;
	static {
		highSpeedTrainEmissions = new HashMap<Long, Float>();
		highSpeedTrainEmissions.put((long)6,(float) 2.0123);
		highSpeedTrainEmissions.put((long)7,(float) 0.6981);
		highSpeedTrainEmissions.put((long)8,(float) 0.4511);

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
