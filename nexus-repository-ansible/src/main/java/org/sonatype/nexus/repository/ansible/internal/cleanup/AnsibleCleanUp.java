package org.sonatype.nexus.repository.ansible.internal.cleanup;
import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.cleanup.config.CleanupPolicyConfiguration;

import com.google.common.collect.ImmutableMap;
import org.sonatype.nexus.repository.ansible.internal.AnsibleFormat;

import static org.sonatype.nexus.repository.search.DefaultComponentMetadataProducer.IS_PRERELEASE_KEY;
import static org.sonatype.nexus.repository.search.DefaultComponentMetadataProducer.LAST_BLOB_UPDATED_KEY;
import static org.sonatype.nexus.repository.search.DefaultComponentMetadataProducer.LAST_DOWNLOADED_KEY;
import static org.sonatype.nexus.repository.search.DefaultComponentMetadataProducer.REGEX_KEY;


/**
 * Defines which cleanup policy fields to display for Helm.
 *
 * @since 1.0.0
 */
@Named(AnsibleFormat.NAME)
@Singleton
public class AnsibleCleanUp implements CleanupPolicyConfiguration {
    @Override
    public Map<String, Boolean> getConfiguration() {
        return ImmutableMap.of(LAST_BLOB_UPDATED_KEY, true,
                LAST_DOWNLOADED_KEY, true,
                IS_PRERELEASE_KEY, false,
                REGEX_KEY, true);
    }
}

