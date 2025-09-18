
import java.io.IOException;


public class MainJavaIO {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new NIOFilePersistance("user.csv");
        System.out.println(persistence.write("bianca;bianca@bianca.com;22/09/1992"));
        System.out.println("================================");
        System.out.println(persistence.write("bernado;bernado@bernado.com;28/11/1999"));
        System.out.println("================================");
        System.out.println(persistence.write("ricardo;ricardo@ricardo.com;28/11/1999"));
        System.out.println("================================");
System.out.println(persistence.findAll());

    }
}
