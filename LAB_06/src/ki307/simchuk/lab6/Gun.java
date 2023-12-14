/**
 * Package
 */
package ki307.simchuk.lab6;
/**
 * Class which implements gun
 */
public class Gun implements Comparable<Gun> {
	private String name;
    private String serialNumber;
/**
 * Constructor
 * @param name Name of the gun
 * @param serialNumber number of the gun 
 */
    public Gun(String name, String serialNumber) {
        this.name = name;
        this.serialNumber = serialNumber;
    }
/**
 * Method that get serial number
 * @return serial number of the gun
 */
    public String getSerialNumber() {
        return serialNumber;
    }
    /**
     * Method that compares a serial number
     */
    @Override
    public int compareTo(Gun other) {
        return serialNumber.compareTo(other.getSerialNumber());
    }
}
