package org.sonatype.nexus.repository.ansible;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.sonatype.nexus.common.collect.NestedAttributesMap;
import org.sonatype.repository.ansible.internal.database.AnsibleProperties;

public class AnsibleAttributes {
    private final Map<AnsibleProperties, Object> attributesEnumMap;

    public AnsibleAttributes() {
        attributesEnumMap = new EnumMap<>(AnsibleAttributes.class);
    }

    public AnsibleAttributes(final Map<String, Object> attributesMap) {
        attributesEnumMap = new EnumMap<>(AnsibleAttributes.class);
        attributesMap.forEach((key, value) -> {
            Optional<AnsibleProperties> propertyOpt = AnsibleProperties.findByPropertyName(key);
            if (value != null && propertyOpt.isPresent()) {
                attributesEnumMap.put(propertyOpt.get(), value);
            }
        });
    }

    public void populate(final NestedAttributesMap attributesMap) {
        attributesEnumMap.forEach((helmProperties, o) -> attributesMap.set(helmProperties.getPropertyName(), o));
    }

    public String getName() {
        return getValue(AnsibleProperties.NAME, String.class);
    }

    public String getVersion() {
        return getValue(AnsibleProperties.VERSION, String.class);
    }

    public String getAppVersion() {
        return getValue(AnsibleProperties.APP_VERSION, String.class);
    }

    public String getDescription() {
        return getValue(AnsibleProperties.DESCRIPTION, String.class);
    }

    public String getIcon() {
        return getValue(AnsibleProperties.ICON, String.class);
    }

    public String getEngine() {
        return getValue(AnsibleProperties.ENGINE, String.class);
    }

    public List<String> getKeywords() {
        return getValue(AnsibleProperties.KEYWORDS, List.class);
    }


    public List<Map<String, String>> getMaintainers() {

        return getValue(AnsibleProperties.MAINTAINERS, List.class);
    }

    public List<String> getSources() {
        return getValue(AnsibleProperties.SOURCES, List.class);
    }

    public void setName(final String name) {
        attributesEnumMap.put(AnsibleProperties.NAME, name);
    }

    public void setDescription(final String description) {
        attributesEnumMap.put(AnsibleProperties.DESCRIPTION, description);
    }

    public void setVersion(final String version) {
        attributesEnumMap.put(AnsibleProperties.VERSION, version);
    }

    public void setIcon(final String icon) {
        attributesEnumMap.put(AnsibleProperties.ICON, icon);
    }

    public void setAppVersion(final String appVersion) {
        attributesEnumMap.put(AnsibleProperties.APP_VERSION, appVersion);
    }

    public void setEngine(final String engine) {
        attributesEnumMap.put(AnsibleProperties.ENGINE, engine);
    }

    public void setKeywords(final List<String> keywords) {
        attributesEnumMap.put(AnsibleProperties.KEYWORDS, keywords);
    }

    public void setMaintainers(final List<Map<String, String>> maintainers) {
        attributesEnumMap.put(AnsibleProperties.MAINTAINERS, maintainers);
    }

    private <T> T getValue(AnsibleProperties property, Class<T> tClass) {
        return tClass.cast(attributesEnumMap.get(property));
    }
}
