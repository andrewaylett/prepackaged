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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * Goal which copies the existing jar
 */
@Mojo(name = "set-artifact", defaultPhase = LifecyclePhase.VERIFY)
public class SetArtifactMojo extends AbstractMojo {
    @Parameter(defaultValue = "${basedir}/${project.artifactId}-${project.version}.jar", property = "source", required = true)
    private File artifactFile;

    @Parameter(property = "project")
    protected MavenProject project;

    public void execute() throws MojoExecutionException {
        getLog().info("Setting artifact file to " + artifactFile.toString());
        project.getArtifact().setFile(artifactFile);
    }
}
