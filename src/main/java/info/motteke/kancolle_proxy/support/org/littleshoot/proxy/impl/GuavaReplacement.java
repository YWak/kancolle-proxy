package info.motteke.kancolle_proxy.support.org.littleshoot.proxy.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public final class GuavaReplacement {

	public static byte[] toByteArray(InputStream in) throws IOException {
		Objects.requireNonNull(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int len;
		
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		
		return out.toByteArray();
	}
	
	public static byte[] base64decode(String value) {
		return Base64.getDecoder().decode(value);
	}
	
	public static <T> List<T> immutableList(@SuppressWarnings("unchecked") T... args) {
		return Collections.unmodifiableList(List.<T>of(args));
	}
	
	public static <T> List<T> copyOfImmutableList(List<T> list) {
		return Collections.unmodifiableList(new ArrayList<>(list));
	}
	
	public static class ImmutableListBuilder<T> {
		private List<T> list = new ArrayList<>();
		
		public void addAll(Collection<T> collection) {
			list.addAll(collection);
		}
		
		public List<T> build() {
			return Collections.unmodifiableList(list);
		}
	}
	
	@Getter
	@RequiredArgsConstructor
	public static class HostAndPort {
		
	}
}
