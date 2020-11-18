public interface IInterpreter {
    public ServiceInfo[] Parse(byte[] bytes);
    public byte[] ToBytes (ServiceInfo[] services);
}
