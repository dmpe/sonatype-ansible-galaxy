package org.sonatype.nexus.repository.ansible.internal.cleanup;

import com.google.common.collect.ImmutableMap;
import org.sonatype.nexus.cleanup.config.CleanupPolicyConfiguration;
import org.sonatype.nexus.repository.ansible.internal.AnsibleFormat;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Map;

import static org.sonatype.nexus.repository.search.DefaultComponentMetadataProducer.*;


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

