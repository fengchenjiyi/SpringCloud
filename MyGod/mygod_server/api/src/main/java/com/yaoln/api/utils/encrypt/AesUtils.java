package com.yaoln.api.utils.encrypt;


import com.yaoln.api.utils.CommonUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密工具类（只实现部分）
 * MD5加密、AES
 * <p>
 * 对称加密常用算法:
 * AES、DES、3DES、TDEA、Blowfish、RC2、RC4、RC5、IDEA、SKIPJACK 等。
 * 非对称加密常用算法:
 * RSA、Elgamal、背包算法、Rabin、D-H、ECC（椭圆曲线加密算法）等，其中支付宝使用的就是RSA算法
 */

public class AesUtils {

    private AesUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 转变
     * <p>法算法名称/加密模式/填充方式</p>
     * <p>加密模式有：电子密码本模式ECB、加密块链模式CBC、加密反馈模式CFB、输出反馈模式OFB</p>
     * <p>填充方式有：NoPadding、ZerosPadding、PKCS5Padding</p>
     */
    public static String AES_MODE = "AES/ECB/PKCS5Padding";
    private static final String AES = "AES";


    /**
     * 随机生成Key
     * @return
     */
    public static String getKey(int count) {
        //产生AES秘钥
        StringBuilder aesKey = new StringBuilder();
        for(int i=0; i<count; i++){
            aesKey.append(CommonUtils.uuid());
        }
        return aesKey.toString();
    }

    /**
     * AES加密
     *
     * @param content 明文
     * @param pass  秘钥
     * @return 密文
     */
    public static String encryptAES(String content, String pass) throws Exception {
        Cipher aesECB = Cipher.getInstance(AES_MODE);
        SecretKeySpec key = getSecretKeySpec(pass);
        aesECB.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = aesECB.doFinal(content.getBytes());
        return parseByte2HexStr(result);
    }

    /**
     * AES解密
     *
     * @param content 密文
     * @param pass  秘钥
     * @return 明文
     */
    public static String decryptAES(String content, String pass) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_MODE);
        SecretKeySpec key = getSecretKeySpec(pass);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result = parseHexStr2Byte(content);
        return new String(cipher.doFinal(result));
    }

    private static SecretKeySpec getSecretKeySpec(String key) throws Exception {
        byte[] arrBTmp = key.getBytes();
        byte[] arrB = new byte[16];
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        return new SecretKeySpec(arrB, AES);
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
