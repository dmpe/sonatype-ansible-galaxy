package org.sonatype.nexus.repository.ansible.internal;

import com.google.common.collect.ImmutableList;
import org.sonatype.nexus.common.hash.HashAlgorithm;
import org.sonatype.nexus.repository.Format;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

import static org.sonatype.nexus.common.hash.HashAlgorithm.SHA1;
import static org.sonatype.nexus.common.hash.HashAlgorithm.SHA256;

/**
 * Ansible repository format.
 */
@Named(AnsibleFormat.NAME)
@Singleton
public class AnsibleFormat extends Format {

    public static final String NAME = "ansible";

    public static final List<HashAlgorithm> HASH_ALGORITHMS = ImmutableList.of(SHA1, SHA256);

    public AnsibleFormat() {
        super(NAME);
    }
}

