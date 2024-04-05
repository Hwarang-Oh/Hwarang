package com.ssafy.util;

public class HashUtil {
	    public static String sha1(String input) {
	        try {
	            byte[] bytes = input.getBytes("UTF-8");
	            
	            int[] h0 = {0x67452301};
	            int[] h1 = {0xEFCDAB89};
	            int[] h2 = {0x98BADCFE};
	            int[] h3 = {0x10325476};
	            int[] h4 = {0xC3D2E1F0};
	            
	            byte[] paddedBytes = addPadding(bytes);
	            
	            for (int i = 0; i < paddedBytes.length; i += 64) {
	                int[] words = new int[80];
	                for (int j = 0; j < 16; j++) {
	                    words[j] = (paddedBytes[i + j * 4] << 24)
	                            | (paddedBytes[i + j * 4 + 1] << 16)
	                            | (paddedBytes[i + j * 4 + 2] << 8)
	                            | (paddedBytes[i + j * 4 + 3]);
	                }
	                for (int j = 16; j < 80; j++) {
	                    words[j] = leftRotate(words[j - 3] ^ words[j - 8] ^ words[j - 14] ^ words[j - 16], 1);
	                }
	                int a = h0[0];
	                int b = h1[0];
	                int c = h2[0];
	                int d = h3[0];
	                int e = h4[0];
	                for (int j = 0; j < 80; j++) {
	                    int f, k;
	                    if (j < 20) {
	                        f = (b & c) | ((~b) & d);
	                        k = 0x5A827999;
	                    } else if (j < 40) {
	                        f = b ^ c ^ d;
	                        k = 0x6ED9EBA1;
	                    } else if (j < 60) {
	                        f = (b & c) | (b & d) | (c & d);
	                        k = 0x8F1BBCDC;
	                    } else {
	                        f = b ^ c ^ d;
	                        k = 0xCA62C1D6;
	                    }
	                    int temp = leftRotate(a, 5) + f + e + k + words[j];
	                    e = d;
	                    d = c;
	                    c = leftRotate(b, 30);
	                    b = a;
	                    a = temp;
	                }
	                h0[0] += a;
	                h1[0] += b;
	                h2[0] += c;
	                h3[0] += d;
	                h4[0] += e;
	            }
	            
	            return Integer.toHexString(h0[0]) + Integer.toHexString(h1[0])
	                    + Integer.toHexString(h2[0]) + Integer.toHexString(h3[0])
	                    + Integer.toHexString(h4[0]);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    private static int leftRotate(int value, int shift) {
	        return (value << shift) | (value >>> (32 - shift));
	    }

	    private static byte[] addPadding(byte[] bytes) {
	        int initialLength = bytes.length;
	        int paddingLength = 64 - (initialLength % 64);
	        int paddedLength = initialLength + paddingLength;
	        byte[] paddedBytes = new byte[paddedLength];
	        System.arraycopy(bytes, 0, paddedBytes, 0, initialLength);
	        paddedBytes[initialLength] = (byte) 0x80;
	        long lengthInBits = (long) initialLength * 8;
	        paddedBytes[paddedLength - 8] = (byte) ((lengthInBits >> 56) & 0xFF);
	        paddedBytes[paddedLength - 7] = (byte) ((lengthInBits >> 48) & 0xFF);
	        paddedBytes[paddedLength - 6] = (byte) ((lengthInBits >> 40) & 0xFF);
	        paddedBytes[paddedLength - 5] = (byte) ((lengthInBits >> 32) & 0xFF);
	        paddedBytes[paddedLength - 4] = (byte) ((lengthInBits >> 24) & 0xFF);
	        paddedBytes[paddedLength - 3] = (byte) ((lengthInBits >> 16) & 0xFF);
	        paddedBytes[paddedLength - 2] = (byte) ((lengthInBits >> 8) & 0xFF);
	        paddedBytes[paddedLength - 1] = (byte) (lengthInBits & 0xFF);
	        return paddedBytes;
	    }
}
