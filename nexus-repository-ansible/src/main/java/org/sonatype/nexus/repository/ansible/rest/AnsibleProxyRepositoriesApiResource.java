/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2017-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.repository.ansible.rest;

import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.sonatype.nexus.repository.ansible.api.AnsibleProxyRepositoryApiRequest;
import org.sonatype.nexus.repository.rest.api.AbstractRepositoriesApiResource;
import org.sonatype.nexus.validation.Validate;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import static org.sonatype.nexus.rest.ApiDocConstants.*;

/**
 * @since 1.1.8
 */
@Api(value = API_REPOSITORY_MANAGEMENT)
public abstract class AnsibleProxyRepositoriesApiResource extends AbstractRepositoriesApiResource<AnsibleProxyRepositoryApiRequest> {
    @ApiOperation("Create Ansible proxy repository")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = REPOSITORY_CREATED),
            @ApiResponse(code = 401, message = AUTHENTICATION_REQUIRED),
            @ApiResponse(code = 403, message = INSUFFICIENT_PERMISSIONS)
    })
    @POST
    @RequiresAuthentication
    @Validate
    @Override
    public Response createRepository(final AnsibleProxyRepositoryApiRequest request) {
        return super.createRepository(request);
    }

    @ApiOperation("Update Ansible proxy repository")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = REPOSITORY_UPDATED),
            @ApiResponse(code = 401, message = AUTHENTICATION_REQUIRED),
            @ApiResponse(code = 403, message = INSUFFICIENT_PERMISSIONS),
            @ApiResponse(code = 404, message = REPOSITORY_NOT_FOUND)
    })
    @PUT
    @Path("/{repositoryName}")
    @RequiresAuthentication
    @Validate
    @Override
    public Response updateRepository(final AnsibleProxyRepositoryApiRequest request,
                                     @ApiParam(value = "Name of the repository to update") @PathParam("repositoryName") final String repositoryName) {
        return super.updateRepository(request, repositoryName);
    }
}
