package io.advantageous.qbit.service.discovery;

import io.advantageous.qbit.service.Startable;
import io.advantageous.qbit.service.Stoppable;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Service Discovery
 * Created by rhightower on 3/23/15.
 */
public interface ServiceDiscovery extends Startable, Stoppable {

    default ServiceDefinition register(
            final String serviceName,
            final int port) {

        return new ServiceDefinition(HealthStatus.PASS,
                serviceName + "." + UUID.randomUUID().toString(),
                serviceName, null, port);
    }



    default ServiceDefinition registerWithTTL(
            final String serviceName,
            final int port,
            final int timeToLiveSeconds) {

        return new ServiceDefinition(HealthStatus.PASS,
                serviceName + "." + UUID.randomUUID().toString(),
                serviceName, null, port, timeToLiveSeconds);
    }



    default ServiceDefinition registerWithIdAndTimeToLive(
            final String serviceName, final String serviceId, final int port, final int timeToLiveSeconds) {

        return new ServiceDefinition(HealthStatus.PASS,
                serviceId,
                serviceName, null, port, timeToLiveSeconds);
    }

    default ServiceDefinition registerWithId(final String serviceName, final String serviceId, final int port) {

        return new ServiceDefinition(HealthStatus.PASS,
                serviceId,
                serviceName, null, port);
    }



    void watch(String serviceName);

    default void checkIn(String serviceId, HealthStatus healthStatus) {

    }


    default void checkInOk(String serviceId) {

    }

    default List<ServiceDefinition> loadServices(final String serviceName) {

        return Collections.emptyList();
    }


    default void start() {}
    default void stop() {}

}
