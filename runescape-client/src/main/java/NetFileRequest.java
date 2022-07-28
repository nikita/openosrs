import net.runelite.mapping.ObfuscatedName;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.Implements;
import java.io.File;
import net.runelite.mapping.Export;
@ObfuscatedName("lz")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("a")
	@Export("Tiles_hue")
	static int[] Tiles_hue;

	@ObfuscatedName("o")
	@ObfuscatedSignature(descriptor = "Llu;")
	@Export("archive")
	public Archive archive;

	@ObfuscatedName("q")
	@ObfuscatedGetter(intValue = -1369001765)
	@Export("crc")
	public int crc;

	@ObfuscatedName("f")
	@Export("padding")
	public byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(descriptor = "(Ljava/lang/String;I)Ljava/io/File;", garbageValue = "-681286598")
	@Export("getFile")
	public static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = ((File) (FileSystem.FileSystem_cacheFiles.get(var0)));
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;
				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}
					throw new RuntimeException();
				}
			}
		}
	}
}