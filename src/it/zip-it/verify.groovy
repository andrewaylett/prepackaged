import java.nio.file.Files

File jarFile = new File(basedir, "../../local-repo/eu/aylett/prepackaged/it/zip-it/1.0-SNAPSHOT/zip-it-1.0-SNAPSHOT.zip");

assert jarFile.isFile()
assert Files.size(jarFile.toPath()) == 0
