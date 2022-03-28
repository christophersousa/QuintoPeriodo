import java.util.List;

public class teste {
    public static String exportBody(String subTitle, List<String> dados){
        String t = "";

        for(String d : dados){
            t +=  "<p>" + d + "</p>";
        }
        return "<main><h2>"+subTitle+"</h2>" + t;
    };
}
