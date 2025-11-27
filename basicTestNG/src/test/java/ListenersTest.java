import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListenersTest implements ITestListener {

    // Listeners: são funções do testng  que vão executar quando forem trigados - tipo uma trigger


    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("sempre que o test tiver sucesso faz o que está aki");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.printf("Teste %s como nome %s falhou!!\n",  result.getName(), result.getTestName());
    }

    @Test
    public void handlingListeners() {
        System.out.println("Running ");

    }

}
