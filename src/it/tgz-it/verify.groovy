import java.nio.file.Files

File jarFile = new File(basedir, "../../local-repo/eu/aylett/prepackaged/it/tgz-it/1.0-SNAPSHOT/tgz-it-1.0-SNAPSHOT.tgz");

assert jarFile.isFile()
assert Files.size(jarFile.toPath()) == 0
