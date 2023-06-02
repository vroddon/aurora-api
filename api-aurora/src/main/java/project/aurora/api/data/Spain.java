package project.aurora.api.data;

import java.util.HashMap;
import java.util.Map;

public class Spain {
	
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
	    fuelCarEnergy.put((long) 1,(float) 0.7478);
	    fuelCarEnergy.put((long) 2,(float) 0.3899);
	    fuelCarEnergy.put((long) 3,(float) 0.2706);
	    fuelCarEnergy.put((long) 4,(float) 0.2110);
	    fuelCarEnergy.put((long) 5,(float) 0.1752);
	}
	
	public static Map<Long, Float> electricCarEnergy;
	static {
		electricCarEnergy = new HashMap<Long, Float>();
		electricCarEnergy.put((long)1,(float) 0.3268);
		electricCarEnergy.put((long)2,(float) 0.1664);
		electricCarEnergy.put((long)3,(float) 0.1129);
		electricCarEnergy.put((long)4,(float) 0.0862);
		electricCarEnergy.put((long)5,(float) 0.0701);

	}
	
	public static Map<Long, Float> hybridCarEnergy;
	static {
		hybridCarEnergy = new HashMap<Long, Float>();
		hybridCarEnergy.put((long)1,(float) 0.3826);
		hybridCarEnergy.put((long)2,(float) 0.1998);
		hybridCarEnergy.put((long)3,(float) 0.1389);
		hybridCarEnergy.put((long)4,(float) 0.1084);
		hybridCarEnergy.put((long)5,(float) 0.0901);

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
		electricMotorcycleEnergy.put((long)1,(float) 0.1322);
		electricMotorcycleEnergy.put((long)2,(float) 0.0661);

	}
	
	public static Map<Long, Float> electricBikeEnergy;
	static {
		electricBikeEnergy = new HashMap<Long, Float>();
		electricBikeEnergy.put((long)1,(float) 0.0119);

	}
	
	public static Map<Long, Float> electricScooterEnergy;
	static {
		electricScooterEnergy = new HashMap<Long, Float>();
		electricScooterEnergy.put((long)1,(float) 0.0257);

	}
	
	public static Map<Long, Float> busEnergy;
	static {
		busEnergy = new HashMap<Long, Float>();
		busEnergy.put((long)6,(float) 0.3826);
		busEnergy.put((long)7,(float) 0.1998);
		busEnergy.put((long)8,(float) 0.1389);

	}
	
	public static Map<Long, Float> metroTramEnergy;
	static {
		metroTramEnergy = new HashMap<Long, Float>();
		metroTramEnergy.put((long)6,(float) 0.2303);
		metroTramEnergy.put((long)7,(float) 0.0773);
		metroTramEnergy.put((long)8,(float) 0.0484);

	}
	
	public static Map<Long, Float> electricPassengerTrainEnergy;
	static {
		electricPassengerTrainEnergy = new HashMap<Long, Float>();
		electricPassengerTrainEnergy.put((long)6,(float) 0.9086);
		electricPassengerTrainEnergy.put((long)7,(float) 0.2930);
		electricPassengerTrainEnergy.put((long)8,(float) 0.1766);

	}
	
	public static Map<Long, Float> highSpeedTrainEnergy;
	static {
		highSpeedTrainEnergy = new HashMap<Long, Float>();
		highSpeedTrainEnergy.put((long)6,(float) 0.2927);
		highSpeedTrainEnergy.put((long)7,(float) 0.0971);
		highSpeedTrainEnergy.put((long)8,(float) 0.0602);

	}
	
	/*
	 * 
	 * EMISSIONS VALUES
	 * 
	 */
	
	public static Map<Long, Float> fuelCarEmissions;
	static {
	    fuelCarEmissions = new HashMap<Long, Float>();
	    fuelCarEmissions.put((long) 1,(float) 0.1897);
	    fuelCarEmissions.put((long) 2,(float) 0.0771);
	    fuelCarEmissions.put((long) 3,(float) 0.0557);
	    fuelCarEmissions.put((long) 4,(float) 0.0451);
	    fuelCarEmissions.put((long) 5,(float) 0.0388);
	}
	
	public static Map<Long, Float> electricCarEmissions;
	static {
		electricCarEmissions = new HashMap<Long, Float>();
		electricCarEmissions.put((long)1,(float) 0.0621);
		electricCarEmissions.put((long)2,(float) 0.0107);
		electricCarEmissions.put((long)3,(float) 0.0075);
		electricCarEmissions.put((long)4,(float) 0.0059);
		electricCarEmissions.put((long)5,(float) 0.0049);

	}
	
	public static Map<Long, Float> hybridCarEmissions;
	static {
		hybridCarEmissions = new HashMap<Long, Float>();
		hybridCarEmissions.put((long)1,(float) 0.0849);
		hybridCarEmissions.put((long)2,(float) 0.0170);
		hybridCarEmissions.put((long)3,(float) 0.0118);
		hybridCarEmissions.put((long)4,(float) 0.0092);
		hybridCarEmissions.put((long)5,(float) 0.0077);

	}
	
	public static Map<Long, Float> motorcycleEmissions;
	static {
		motorcycleEmissions = new HashMap<Long, Float>();
		motorcycleEmissions.put((long)1,(float) 0.1112);
		motorcycleEmissions.put((long)2,(float) 0.0280);

	}
	
	public static Map<Long, Float> electricMotorcycleEmissions;
	static {
		electricMotorcycleEmissions = new HashMap<Long, Float>();
		electricMotorcycleEmissions.put((long)1,(float) 0.0251);
		electricMotorcycleEmissions.put((long)2,(float) 0.0018);

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
		busEmissions.put((long)6,(float) 1.3425);
		busEmissions.put((long)7,(float) 0.4992);
		busEmissions.put((long)8,(float) 0.3432);

	}
	
	public static Map<Long, Float> metroTramEmissions;
	static {
		metroTramEmissions = new HashMap<Long, Float>();
		metroTramEmissions.put((long)6,(float) 0.2289);
		metroTramEmissions.put((long)7,(float) 0.0841);
		metroTramEmissions.put((long)8,(float) 0.0571);

	}
	
	public static Map<Long, Float> electricPassengerTrainEmissions;
	static {
		electricPassengerTrainEmissions = new HashMap<Long, Float>();
		electricPassengerTrainEmissions.put((long)6,(float) 3.2875);
		electricPassengerTrainEmissions.put((long)7,(float) 1.0858);
		electricPassengerTrainEmissions.put((long)8,(float) 0.6700);

	}
	
	public static Map<Long, Float> highSpeedTrainEmissions;
	static {
		highSpeedTrainEmissions = new HashMap<Long, Float>();
		highSpeedTrainEmissions.put((long)6,(float) 1.4341);
		highSpeedTrainEmissions.put((long)7,(float) 0.5114);
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
