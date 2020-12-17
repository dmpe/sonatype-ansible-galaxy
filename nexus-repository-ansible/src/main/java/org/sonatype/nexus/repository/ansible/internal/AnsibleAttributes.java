package org.sonatype.nexus.repository.ansible.internal;

import org.sonatype.nexus.common.collect.NestedAttributesMap;
import org.sonatype.nexus.repository.ansible.internal.database.AnsibleProperties;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public String getNamespace() {
        return getValue(AnsibleProperties.NAMESPACE, String.class);
    }

    public void setNamespace(final String namespace) {
        attributesEnumMap.put(AnsibleProperties.NAMESPACE, namespace);
    }

    public String getName() {
        return getValue(AnsibleProperties.NAME, String.class);
    }

    public void setName(final String name) {
        attributesEnumMap.put(AnsibleProperties.NAME, name);
    }

    public String getVersion() {
        return getValue(AnsibleProperties.VERSION, String.class);
    }

    public void setVersion(final String version) {
        attributesEnumMap.put(AnsibleProperties.VERSION, version);
    }

    public List<Map<String, String>> getAuthors() {

        return getValue(AnsibleProperties.AUTHORS, List.class);
    }

    public void setAuthors(final List<Map<String, String>> maintainers) {
        attributesEnumMap.put(AnsibleProperties.AUTHORS, maintainers);
    }

    public List<String> getTags() {
        return getValue(AnsibleProperties.TAGS, List.class);
    }

    public void setTags(final List<String> tags) {
        attributesEnumMap.put(AnsibleProperties.TAGS, tags);
    }

    public String getDescription() {
        return getValue(AnsibleProperties.DESCRIPTION, String.class);
    }

    public void setDescription(final String description) {
        attributesEnumMap.put(AnsibleProperties.DESCRIPTION, description);
    }

    public String getLicense() {
        return getValue(AnsibleProperties.LICENSE, String.class);
    }

    public void setLicense(final String license) {
        attributesEnumMap.put(AnsibleProperties.LICENSE, license);
    }

    public void setDocs(final String docs) {
        attributesEnumMap.put(AnsibleProperties.DOCUMENTATION, docs);
    }

    public String getDocs() {
        return getValue(AnsibleProperties.DOCUMENTATION, String.class);
    }

    public String getIssues() {
        return getValue(AnsibleProperties.ISSUES, String.class);
    }

    public void setIssues(final String issues) {
        attributesEnumMap.put(AnsibleProperties.ISSUES, issues);
    }

    public String getHomepage() {
        return getValue(AnsibleProperties.HOMEPAGE, String.class);
    }

    public void setHomepage(final String home) {
        attributesEnumMap.put(AnsibleProperties.HOMEPAGE, home);
    }

    private <T> T getValue(AnsibleProperties property, Class<T> tClass) {
        return tClass.cast(attributesEnumMap.get(property));
    }
}
