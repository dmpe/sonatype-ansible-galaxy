# declaration of NEXUS_VERSION must appear before first FROM command
# see: https://docs.docker.com/engine/reference/builder/#understand-how-arg-and-from-interact
ARG NEXUS_VERSION=latest

FROM maven:3-jdk-8-alpine AS build

COPY . /nexus-repository-ansible/
RUN cd /nexus-repository-ansible/; \
    mvn clean package -PbuildKar;

FROM sonatype/nexus3:$NEXUS_VERSION

ARG FORMAT_VERSION=0.0.1-SNAPSHOT
ARG DEPLOY_DIR=/opt/sonatype/nexus/deploy/
USER root
COPY --from=build /ansible-parent/ansible-parent/target/ansible-parent-${FORMAT_VERSION}-bundle.kar ${DEPLOY_DIR}
USER nexus