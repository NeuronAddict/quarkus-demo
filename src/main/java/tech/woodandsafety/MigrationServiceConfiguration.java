package tech.woodandsafety;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

@ApplicationScoped
class MigrationServiceConfiguration {

    @ConfigProperty(name = "application.flyway.migrate")
    String runMigration;

    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    String datasourceJdbcUrl;

    @ConfigProperty(name = "quarkus.datasource.username")
    String datasourceUsername;

    @ConfigProperty(name = "quarkus.datasource.password")
    String datasourcePassword;

    void runFlywayMigration(@Observes StartupEvent event) {

        if ("true".equals(runMigration)) {
            Flyway flyway = Flyway.configure().dataSource(datasourceJdbcUrl, datasourceUsername, datasourcePassword)
                    .baselineOnMigrate(true)
                    .load();
            flyway.migrate();
        }
    }
}