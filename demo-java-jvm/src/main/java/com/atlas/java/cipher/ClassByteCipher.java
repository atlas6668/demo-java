package com.atlas.java.cipher;

/**
 * @author sunwenming
 * @date 2019/3/3.
 */
public interface ClassByteCipher {

    byte[] encrypt(byte[] plainData);

    byte[] decrypt(byte[] cipherData);

}
