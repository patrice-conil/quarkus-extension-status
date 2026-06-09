package org.pconil.quarkus.extension.status.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.AdditionalIndexedClassesBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.pconil.quarkus.extension.status.runtime.StatusController;

import java.util.HashSet;
import java.util.Set;

class QuarkusExtensionStatusProcessor {

    private static final String FEATURE = "quarkus-extension-status";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    AdditionalIndexedClassesBuildItem additionalIndexedClassesBuildItem() {
        Set<String> set = new HashSet<>();
        set.add(StatusController.class.getName());
        return new AdditionalIndexedClassesBuildItem(set.toArray(new String[]{}));
    }
}
