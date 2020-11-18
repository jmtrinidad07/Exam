public class App {
    public static void main(String[] args) throws Exception {
        byte[] SST = { (byte) 0xFF,(byte)0x33,(byte) 0xFF, (byte) 0x3F, (byte)0x3F, (byte)0x00 , (byte)0x3F, (byte)0x07, (byte)0x00, (byte)0x0C, (byte)0xF0, (byte)0x03, (byte)0x50, (byte)0xFF, (byte)0x00 };
        ServiceInfo ArrayObj[] = new ServiceInfo[SST.length];
        for(int i = 0 ; i < SST.length; i++ ){
            ArrayObj[i] = new ServiceInfo();
        }
        
        SSTInterpreter a = new SSTInterpreter(ArrayObj);
        a.serviceObj = a.Parse(SST);
        System.out.println(a.toString());
    }
}
