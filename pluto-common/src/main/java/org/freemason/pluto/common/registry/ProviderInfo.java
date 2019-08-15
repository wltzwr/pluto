package org.freemason.pluto.common.registry;

import org.springframework.util.LinkedMultiValueMap;


public class ProviderInfo {
    private static final ProviderInfo PROVIDER_INFO = new ProviderInfo();
    private ProviderInfo(){}
    public static ProviderInfo getInstance(){
        return PROVIDER_INFO;
    }
    private String applicationName;

    private String ipAddress;

    private int port;

    private LinkedMultiValueMap<String, String> providerService;

    private StatusEnum status;


    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public LinkedMultiValueMap<String, String> getProviderService() {
        return providerService;
    }

    public void setProviderService(LinkedMultiValueMap<String, String> providerService) {
        this.providerService = providerService;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(int load) {
        this.status = StatusEnum.getStatus(load);
    }

    enum StatusEnum{
        FREE(0),
        LOW(25),
        MEDIUM(50),
        HIGH(75),
        FULL(100),
        OVERLOAD(200);

        private int load;

        int getLoad(){
            return load;
        }
        StatusEnum(int load){
            this.load = load;
        }
        static StatusEnum getStatus(int load){
            if (load <= FREE.getLoad()){
                return FREE;
            }else if (load <= LOW.getLoad()){
                return LOW;
            }else if (load <= MEDIUM.getLoad()){
                return MEDIUM;
            }else if (load <= HIGH.getLoad()){
                return HIGH;
            }else if (load <= FULL.getLoad()){
                return FULL;
            }else if (load <= OVERLOAD.getLoad()){
                return OVERLOAD;
            } else {
                return null;
            }
        }
    }
}
