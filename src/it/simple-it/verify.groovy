import java.nio.file.Files

File jarFile = new File(basedir, "../../local-repo/eu/aylett/prepackaged/it/simple-it/1.0-SNAPSHOT/simple-it-1.0-SNAPSHOT.jar");

assert jarFile.isFile()
assert Files.size(jarFile.toPath()) == 0
