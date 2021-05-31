import java.io.File;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
public class BookRecommendationServicePy {
    public void callPythonMethods() {
        Context ctx = Context.newBuilder().option("python.CoreHome", "/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.0.0.2/Contents/Home/languages/python/lib-graalpython")
        .option("python.StdLibHome", "/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.0.0.2/Contents/Home/languages/python/lib-python/3")
        .option("python.CAPI", "/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.0.0.2/Contents/Home/languages/python/lib-graalpython")
        .option("python.Executable", "Users/vijaykumarab/AB-Home/Developer/bozo-book-library/bozo-book-prediction-service/bozo-book-lib-env/bin/python")
        .allowAllAccess(true).build();
        try {
            File fibCal = new File("./book-recommendation.py");
            ctx.eval(Source.newBuilder("python", fibCal).build());
            
            Value hearAnalysisFn = ctx.getBindings("python").getMember("heartAnalysis");

            Value heartAnalysisReport = hearAnalysisFn.execute();
            System.out.println("Average age of people who are getting level 3 and greater chest pain :" + heartAnalysisReport.toString());

        }   catch (Exception e) {
            System.out.println("Exception : " );
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BookRecommendationServicePy obj = new BookRecommendationServicePy();
        obj.callPythonMethods();
    }
}
