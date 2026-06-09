package org.pconil.quarkus.extension.status.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Objects;

public class ApiComponent {
    private @Valid ApiStatusValue status;
    private @Valid String name;
    private @Valid String version;

    /**
     *
     **/
    public ApiComponent status(ApiStatusValue status) {
        this.status = status;
        return this;
    }


    @JsonProperty("status")
    @NotNull
    public ApiStatusValue getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(ApiStatusValue status) {
        this.status = status;
    }

    /**
     * Component internal name.
     **/
    public ApiComponent name(String name) {
        this.name = name;
        return this;
    }


    @JsonProperty("name")
    @NotNull
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * major.minor.patch see [semver.org](https://semver.org/) or G00R00C00
     **/
    public ApiComponent version(String version) {
        this.version = version;
        return this;
    }


    @JsonProperty("version")
    @NotNull
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiComponent apiComponent = (ApiComponent) o;
        return Objects.equals(this.status, apiComponent.status) &&
                Objects.equals(this.name, apiComponent.name) &&
                Objects.equals(this.version, apiComponent.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, name, version);
    }

    @Override
    public String toString() {

        String sb = "class ApiComponent {\n" +
                "    status: " + toIndentedString(status) + "\n" +
                "    name: " + toIndentedString(name) + "\n" +
                "    version: " + toIndentedString(version) + "\n" +
                "}";
        return sb;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

