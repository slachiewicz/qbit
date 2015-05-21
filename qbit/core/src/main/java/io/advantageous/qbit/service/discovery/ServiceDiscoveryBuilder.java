package io.advantageous.qbit.service.discovery;

import io.advantageous.qbit.concurrent.PeriodicScheduler;
import io.advantageous.qbit.service.discovery.impl.ServiceDiscoveryImpl;
import io.advantageous.qbit.service.discovery.spi.ServiceDiscoveryProvider;

import java.util.concurrent.ExecutorService;

public class ServiceDiscoveryBuilder {

    private PeriodicScheduler periodicScheduler;
    private ServiceChangedEventChannel serviceChangedEventChannel;
    private ServicePoolListener servicePoolListener;
    private ExecutorService executorService;
    private ServiceDiscoveryProvider serviceDiscoveryProvider;
    private ServiceDiscoveryProvider backupProvider = null;
    private int pollForServicesInterval = 50;

    public static ServiceDiscoveryBuilder serviceDiscoveryBuilder() {
        return new ServiceDiscoveryBuilder();
    }

    public int getPollForServicesInterval() {
        return pollForServicesInterval;
    }

    public ServiceDiscoveryBuilder setPollForServicesInterval(int pollForServicesInterval) {
        this.pollForServicesInterval = pollForServicesInterval;
        return this;
    }


    public ServiceDiscoveryProvider getServiceDiscoveryProvider() {
        return serviceDiscoveryProvider;
    }

    public ServiceDiscoveryBuilder setServiceDiscoveryProvider(ServiceDiscoveryProvider serviceDiscoveryProvider) {
        this.serviceDiscoveryProvider = serviceDiscoveryProvider;
        return this;
    }


    public PeriodicScheduler getPeriodicScheduler() {
        return periodicScheduler;
    }

    public ServiceDiscoveryBuilder setPeriodicScheduler(PeriodicScheduler periodicScheduler) {
        this.periodicScheduler = periodicScheduler;
        return this;
    }

    public ServiceChangedEventChannel getServiceChangedEventChannel() {
        return serviceChangedEventChannel;
    }

    public ServiceDiscoveryBuilder setServiceChangedEventChannel(ServiceChangedEventChannel serviceChangedEventChannel) {
        this.serviceChangedEventChannel = serviceChangedEventChannel;
        return this;
    }

    public ServicePoolListener getServicePoolListener() {
        return servicePoolListener;
    }

    public ServiceDiscoveryBuilder setServicePoolListener(ServicePoolListener servicePoolListener) {
        this.servicePoolListener = servicePoolListener;
        return this;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public ServiceDiscoveryBuilder setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }


    public ServiceDiscoveryProvider getBackupProvider() {
        return backupProvider;
    }

    public ServiceDiscoveryBuilder setBackupProvider(final ServiceDiscoveryProvider backupProvider) {
        this.backupProvider = backupProvider;
        return this;
    }


    public ServiceDiscoveryImpl build() {

        return new ServiceDiscoveryImpl(
                getPeriodicScheduler(), getServiceChangedEventChannel(),
                getServiceDiscoveryProvider(), getBackupProvider(),
                getServicePoolListener(),
                getExecutorService(), getPollForServicesInterval());

    }
}
