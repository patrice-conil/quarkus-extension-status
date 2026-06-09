package org.pconil.quarkus.extension.status.runtime;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.ConfigProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("/status")
public class StatusController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public ApiStatus getServiceStatus() {
        String rootPath = ConfigProvider.getConfig().getValue("quarkus.http.root-path", String.class);
        String[] parts = rootPath.split("/");
        String version;
        String serviceName;

        logger.debug("getServiceStatus()");

        if (parts.length >= 2) {
            version = parts[parts.length - 1];
            serviceName = parts[parts.length - 2];
        } else {
            version = "undefined";
            serviceName = "unknown";
        }
        return new ApiStatus().name(serviceName).version(version).status(ApiStatusValue.OK);
    }
}
