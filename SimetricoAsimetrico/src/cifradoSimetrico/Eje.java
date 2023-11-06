package cifradoSimetrico;

import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Eje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("¿Tiene una clave secreta? (Sí/No):");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        String claveSecreta = null;

        try {
            if (respuesta.equals("si")) {
                System.out.println("Introduce la clave secreta:");
                claveSecreta = scanner.nextLine().trim();
            } else {
                claveSecreta = generarClaveSecreta();
                System.out.println("Se generó una clave secreta automáticamente.");
            }

            System.out.println("Introduce el texto a cifrar:");
            String textoOriginal = scanner.nextLine();

            String textoCifrado = cifrarSimetrico(claveSecreta, textoOriginal);
            if (textoCifrado != null) {
                System.out.println("Texto cifrado: " + textoCifrado);

                String textoDescifrado = descifrarSimetrico(claveSecreta, textoCifrado);
                if (textoDescifrado != null) {
                    System.out.println("Texto descifrado: " + textoDescifrado);
                } else {
                    System.err.println("Error al descifrar el texto.");
                }
            } else {
                System.err.println("Error al cifrar el texto.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static String generarClaveSecreta() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // Usar AES con una clave de 256 bits
            SecretKey secretKey = keyGenerator.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String cifrarSimetrico(String secretKey, String textoSinCifrar) {
        try {
            SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] textoCifrado = cipher.doFinal(textoSinCifrar.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(textoCifrado);
        } catch (Exception e) {
            System.err.println("Error al cifrar: " + e.getMessage());
            return null;
        }
    }

    public static String descifrarSimetrico(String secretKey, String textoCifrado) {
        try {
            SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] textoOriginal = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
            return new String(textoOriginal, "UTF-8");
        } catch (Exception e) {
            System.err.println("Error al descifrar: " + e.getMessage());
            return null;
        }
    }
}
