package cifradoAsimetrico;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;
import java.util.Scanner;

public class Eje {
	private static PublicKey publicKey;
    private static PrivateKey privateKey;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Cifrar un mensaje");
            System.out.println("2. Descifrar un mensaje cifrado");
            System.out.println("3. Regenerar las claves pública y privada");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el mensaje a cifrar:");
                    String mensajeSinCifrar = scanner.nextLine();
                    generarKeysAsimetrica();
                    String mensajeCifrado = cifrarAsimetrico(mensajeSinCifrar);
                    System.out.println("Mensaje cifrado: " + mensajeCifrado);
                    break;
                case 2:
                    System.out.println("Introduce el mensaje cifrado:");
                    String mensajeCifradoInput = scanner.nextLine();
                    String mensajeDescifrado = descifrarAsimetrico(mensajeCifradoInput);
                    System.out.println("Mensaje descifrado: " + mensajeDescifrado);
                    break;
                case 3:
                    generarKeysAsimetrica();
                    System.out.println("Se han regenerado las claves pública y privada.");
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 4.");
            }
        }
    }

    public static void generarKeysAsimetrica() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // Usar RSA con una clave de 2048 bits
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String cifrarAsimetrico(String textoSinCifrar) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] textoCifrado = cipher.doFinal(textoSinCifrar.getBytes());
            return Base64.getEncoder().encodeToString(textoCifrado);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String descifrarAsimetrico(String textoCifrado) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] textoOriginal = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
            return new String(textoOriginal);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
