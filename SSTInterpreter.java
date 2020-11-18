
public class SSTInterpreter implements IInterpreter{
    public final static String Names[] = {"CHV1 disable function", "Abbreviated Dialling Numbers (ADN)","Fixed Dialling Numbers (FDN)",
    "Short Message Storage (SMS)", "Advice of Charge (AoC)", "Capability Configuration Parameters (CCP)", "PLMN selector", "RFU",
    "MSISDN", "Extension1", "Extension2", "SMS Parameters", "Last Number Dialled (LND)", "Cell Broadcast Message Identifier", "Group Identifier Level 1",
    "Group Identifier Level 2", "Service Provider Name", "Service Dialling Numbers (SDN)", "Extension3", "RFU",
    "VCGS Group Identifier List (EFVGCS and EFVGCSS)", " VBS Group Identifier List (EFVBS and EFVBSS", "nhanced Multi-Level Precedence and Pre-emption Service",
    "Automatic Answer for eMLPP", "Data download via SMS-CB", "Data download via SMS-PP", "Menu selection", " Call control", "Proactive SIM",
    "Cell Broadcast Message Identifier Ranges", "RFU", "RFU"};

    public ServiceInfo[] serviceObj;

    @Override
    public ServiceInfo[] Parse(byte[] bytes) {
        for(int i = 0;  i <= bytes.length; i++ ){
            for(int u=i*3;u<i+3; u++){
                serviceObj[u] = new ServiceInfo();
                if(getBit(bytes[i], u+1) == 1){
                    serviceObj[u].isAllocated = true;
                    }
                    else{
                        serviceObj[u].isAllocated = false;
                    }
                    if(getBit(bytes[i], u+2) == 1){
                        serviceObj[u].isActivated = true;
                        }
                        else{
                            serviceObj[u].isActivated = false;
                        }
                    if(i == 1 || i ==2){
                    serviceObj[u].isMandatory = true;
                    }
                    else{serviceObj[u].isMandatory = false;}
                    serviceObj[u].name = Names[u];
            }
            
        } 
        return serviceObj;
    }

    @Override
    public byte[] ToBytes(ServiceInfo[] services) {
        // TODO Auto-generated method stub
        return null;
    }

    private static int getBit(byte data, int pos) {
        int posBit = pos%8;
        byte valByte = data;
        int valInt = valByte>>(8-(posBit+1)) & 0x0001;
        return valInt;
     }
    
    public String toString() {
        String Out ="";
        if (serviceObj != null){
            for(int i=0; i<serviceObj.length; i++){
                Out = Out + serviceObj[i].name + " is ";
            if (serviceObj[i].isActivated == true) {
                Out = Out + "Activated ";
            }
            else{Out = Out + "Deactivated ";}
            if (serviceObj[i].isAllocated == true) {
                Out = Out + "Allocated ";
            }
            else{Out = Out + "Deallocated ";}
            
            if (serviceObj[i].isMandatory == true) {
                Out = Out + "Mandatory ";
            }
            else{Out = Out + "Optional ";}
            Out = Out + "\n";
            }
        }
    return Out ;}

public SSTInterpreter(ServiceInfo[] serviceObj) {
    this.serviceObj = serviceObj;
}

         
}


