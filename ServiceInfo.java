
public class ServiceInfo{

	public String  name; 
    public boolean isAllocated;
    public boolean isActivated;
    public boolean isMandatory;
    public ServiceInfo(String name, boolean isAllocated, boolean isActivated, boolean isMandatory) {
     this.name = name;
     this.isAllocated = isAllocated; 
     this.isActivated = isActivated;
     this.isMandatory = isMandatory;
    }
    public ServiceInfo() {
        this.name = "Test";
        this.isAllocated = false; 
        this.isActivated = false;
        this.isMandatory = false;
       }
}