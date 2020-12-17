package org.sonatype.nexus.repository.ansible.internal.database;

import java.util.Arrays;
import java.util.Optional;

/**
 * Database property names for Ansible asset attributes
 *
 * @since 3.28
 */
public enum AnsibleProperties
{
  NAMESPACE("namespace"),
  NAME("name"),
  VERSION("version"),
  AUTHORS("authors"),
  TAGS("tags"),
  DESCRIPTION("description"),
  LICENSE("license"),
  REPOSITORY("repository"),
  DOCUMENTATION("documentation"),
  ISSUES("issues"),
  HOMEPAGE("homepage");

  private String propertyName;

  AnsibleProperties(final String type) {
    this.propertyName = type;
  }

  public String getPropertyName() {
    return propertyName;
  }

  public static Optional<AnsibleProperties> findByPropertyName(String propertyName) {
    return Arrays.stream(AnsibleProperties.values())
        .filter(properties -> propertyName.equals(properties.getPropertyName()))
        .findAny();
  }
}