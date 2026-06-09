package org.pconil.quarkus.extension.status.runtime;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ApiStatus {
    private @Valid ApiStatusValue status;
    private @Valid String name;
    private @Valid String version;
    private @Valid List<@Valid ApiComponent> components = new ArrayList<>();

    /**
     *
     **/
    public ApiStatus status(ApiStatusValue status) {
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
     * Your service internal name.
     **/
    public ApiStatus name(String name) {
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
    public ApiStatus version(String version) {
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

    /**
     * Each array entry represents a component your service requires (other web service, database, etc) to be fully functional
     **/
    public ApiStatus components(List<@Valid ApiComponent> components) {
        this.components = components;
        return this;
    }


    @JsonProperty("components")
    @Valid
    public List<@Valid ApiComponent> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(List<@Valid ApiComponent> components) {
        this.components = components;
    }

    public ApiStatus addcomponentsItem(ApiComponent componentsItem) {
        if (this.components == null) {
            this.components = new ArrayList<>();
        }

        this.components.add(componentsItem);
        return this;
    }

    public ApiStatus removecomponentsItem(ApiComponent componentsItem) {
        if (componentsItem != null && this.components != null) {
            this.components.remove(componentsItem);
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiStatus apiStatus = (ApiStatus) o;
        return Objects.equals(this.status, apiStatus.status) &&
                Objects.equals(this.name, apiStatus.name) &&
                Objects.equals(this.version, apiStatus.version) &&
                Objects.equals(this.components, apiStatus.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, name, version, components);
    }

    @Override
    public String toString() {

        String sb = "class ApiStatus {\n" +
                "    status: " + toIndentedString(status) + "\n" +
                "    name: " + toIndentedString(name) + "\n" +
                "    version: " + toIndentedString(version) + "\n" +
                "    components: " + toIndentedString(components) + "\n" +
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

