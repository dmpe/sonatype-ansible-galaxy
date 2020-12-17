package org.sonatype.nexus.repository.ansible;

import org.sonatype.nexus.repository.Facet;
import org.sonatype.nexus.repository.storage.Asset;
import org.sonatype.nexus.repository.storage.Component;
import org.sonatype.nexus.repository.storage.StorageTx;

import java.util.Map;

/**
 * General Ansible facet
 *
 * @since 1.1.next
 */
@Facet.Exposed
public interface AnsibleFacet extends Facet {
    /**
     * Find or Create Component
     *
     * @return Component
     */
    Component findOrCreateComponent(final StorageTx tx,
                                    final String path,
                                    final Map<String, String> attributes);

    /**
     * Find or Create Asset
     *
     * @return Asset
     */
    Asset findOrCreateAsset(final StorageTx tx,
                            final Component component,
                            final String path,
                            final Map<String, String> attributes);

    /**
     * Find or Create Asset without Component
     *
     * @return Asset
     */
    Asset findOrCreateAsset(final StorageTx tx, final String path);
}
