package es.koratosun.airlines.webfrontboot.ext.utils.tools;

import java.util.function.DoubleConsumer;
import java.util.function.LongConsumer;
import java.util.function.Supplier;

public class ClassUtils {

	private ClassUtils() {
		throw new IllegalStateException("Clase de Utilidad");
	}

	public static void setLongIfNotNull(final Supplier<String> getter, final LongConsumer setter) {
		String value = getter.get();

		if (value != null && !value.trim().isEmpty()) {
			setter.accept(Long.valueOf(value));
		}
	}
	
	public static void setDoubleIfNotNull(final Supplier<String> getter, final DoubleConsumer setter) {
		String value = getter.get();

		if (value != null && !value.trim().isEmpty()) {
			setter.accept(Double.valueOf(value.replace(",", ".")));
		}
	}
}
