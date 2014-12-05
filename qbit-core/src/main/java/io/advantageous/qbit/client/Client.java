package io.advantageous.qbit.client;

/**
 * Created by rhightower on 12/3/14.
 */
public interface Client {



    /**
     * Creates a new client proxy given a service interface.
     *
     * @param serviceInterface service interface
     * @param serviceName      service name
     * @param <T>              class type of interface
     * @return new client proxy.. calling methods on this proxy marshals method calls to httpServer.
     */
    <T> T createProxy(final Class<T> serviceInterface,
                             final String serviceName);


    void flush();

    void run();

    void stop();

}