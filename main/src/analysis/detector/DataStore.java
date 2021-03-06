package analysis.detector;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import analysis.storage.ListMap;
import analysis.storage.PrimitiveFloatMap;
import analysis.storage.PrimitiveIntMap;
import analysis.storage.SetIntMap;
import analysis.storage.SetStrMap;

/**
 * Wrapper class for storing detection data. Local detectors can have datastore attached to them but if you want data from the Metrics visitor you need to save it somewhere. 
 * @author felixb
 *
 */
public class DataStore {

	private static DataStore instance = null;
	@SuppressWarnings("rawtypes")
	protected Map<String, analysis.storage.Map> dataStores;

	protected DataStore() {
		this.dataStores = new HashMap<>();
	}
	
	public static DataStore getInstance() {
		if (instance == null) {
			instance = new DataStore();
		}
		return instance;
	}

	@SuppressWarnings("rawtypes")
	public void addDataStore(String name, analysis.storage.Map dataStore) {
		this.dataStores.put(name, dataStore);
	}

	/**
	 * Returns PrimitiveIntMap
	 * @param name
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public analysis.storage.Map getPrimitiveIntMapStore(String name) {
		return (PrimitiveIntMap) this.dataStores.get(name);
	}
	
	/**
	 * Returns primitiveFloatMap 
	 * @param name
	 * @return
	 */
	public PrimitiveFloatMap getPrimitiveFloatMapStore(String name) {
			return (PrimitiveFloatMap) this.dataStores.get(name);
		}

	/**
	 * Returns a SetIntMap
	 * @param name of SetIntMap
	 * @return SetIntMap
	 */
	public SetIntMap getIntSetMap(String name) {
		return (SetIntMap) this.dataStores.get(name);
	}
	
	/**
	 * Returns a SetStrMap
	 * @param name of SetStrMap
	 * @return SetStrMap
	 */
	public SetStrMap getStrSetMap(String name) {
		return (SetStrMap) this.dataStores.get(name);
	}

	/**
	 * Returns a listmap
	 * @param name of listmap
	 * @return listmap
	 */
	public ListMap getListMapStore(String name) {
		return (ListMap) this.dataStores.get(name);
	}

	/**
	 * Delete all the data for every store. 
	 */
	public void removeData() {
		this.dataStores.values().forEach(analysis.storage.Map::clean);
	}

	/**
	 * Loops through the Storage maps in DataStores and writes them to file.
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public void deserializeData() throws IOException {
		String currentMap = null;
		try {
			for (analysis.storage.Map m : this.dataStores.values()) {
				currentMap = m.getFilePath();
				m.deserialize();
			}
		} catch (IOException io) {
			io.printStackTrace();
			System.out.println("IO Exception with map: " + currentMap);
			io.printStackTrace(System.out);
		} catch (NumberFormatException e) {
		e.printStackTrace();
		System.out.println("NumberFormat Exception with map: " + currentMap);
		e.printStackTrace(System.out);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Unknown Exception with map: " + currentMap);
		e.printStackTrace(System.out);
	}
		
	}
	
}
