package org.freemason.pluto.common.utils;

import org.nustaq.serialization.FSTConfiguration;

public class SerializationUtils {

    private static final FSTConfiguration FST_CONFIGURATION = FSTConfiguration.createDefaultConfiguration();


    public static byte[] serialize(Object obj) {
        return FST_CONFIGURATION.asByteArray(obj);
    }

    public static <T> T deserialize(byte[] sec, Class<T> clazz) {
        return (T) FST_CONFIGURATION.asObject(sec);
    }

    /*public static byte[] kryoSerialize(Object obj) {
        Kryo kryo = new Kryo();

        byte[] buffer = new byte[2048];
        try (
                Output output = new Output(buffer);
        ) {

            kryo.writeClassAndObject(output, obj);
            return output.toBytes();
        } catch (Exception e) {
        }
        return buffer;
    }


    public static <T> T kryoDeserialize(byte[] src, Class<T> type) {
        Kryo k = new Kryo();
        Input input = new Input(src);
        return k.readObject(input, type);
    }
        */
}
