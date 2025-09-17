
public class MainJavaIO {
    public static void main(String[] args) {
        
        FilePersistence persistence = new IOFilePersistence("user.csv");
        System.out.println("=================");
        System.out.println(persistence.write("Sofia;sofia@sofia.com;15/09/2025"));
        System.out.println("=================");
        System.out.println(persistence.write("Vitor;vitor@sofia.com;14/09/2025"));
        System.out.println("=================");
        System.out.println(persistence.findAll());
        System.out.println("=================");
        System.out.println(persistence.remove("Vitor"));
        System.out.println("=================");
        System.out.println(persistence.findBy("Sofia;"));
        System.out.println("-----");
        System.out.println(persistence.findBy("vitor@"));
        System.out.println("-----");
        System.out.println("=================");
        System.out.println(persistence.replace("Sofia;", "Sofia;sofia@vitor.com;19/05/2005"));
        System.out.println("=================");
        System.out.println(persistence.findAll());
    }
}
