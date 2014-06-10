package eu.aylett.prepackaged;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Goal which copies the existing jar
 */
@Mojo(name = "set-artifact", defaultPhase = LifecyclePhase.VERIFY)
public class SetArtifactMojo extends AbstractMojo {
    @Parameter(defaultValue = "${basedir}/${project.artifactId}-${project.version}.jar", property = "source", required = true)
    protected File artifactFile;

    @Parameter(property = "project")
    protected MavenProject project;

    @Component
    protected ArtifactFactory artifactFactory;

    public void execute() throws MojoExecutionException {
        ArrayList<String> list = newArrayList(artifactFile.getName().split("\\."));
        String packaging = list.get(list.size()-1);
        getLog().info("Setting packaging to " + packaging);
        project.setPackaging(packaging);


        getLog().info("Setting artifact file to " + artifactFile.toString());
        Artifact artifact = artifactFactory.createBuildArtifact(
                project.getGroupId(),
                project.getArtifactId(),
                project.getVersion(),
                packaging);
        artifact.setFile(artifactFile);

        project.setArtifact(artifact);
    }
}
