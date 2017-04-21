import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Ryo on 2017/04/21.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./infiles/twitter4j/twitter4j-core/src/main/java/twitter4j/Query.java");
        CompilationUnit cu = JavaParser.parse(fileInputStream);


        // Find class names and method names
        new ClassAndMethodNameVisitor().visit(cu, null);
    }
}

/**
 * Finder for class names and method names
 */
class ClassAndMethodNameVisitor extends VoidVisitorAdapter<Object> {
    @Override
    public void visit(final ClassOrInterfaceDeclaration n, final Object arg) {
        System.out.printf("VISIT ClassOrInterfaceDeclaration: %s, %s\n", n.getName(), arg);
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration, Object arg) {
        System.out.printf("VISIT MethodDeclaration: %s, %s\n", methodDeclaration.getName(), arg);
        super.visit(methodDeclaration, arg);
    }
}
