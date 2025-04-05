import com.jolvera.jbud.HelloView
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class JBudApplication : Application() {
    override fun start(primaryStage: Stage?) {
        var helloView = HelloView()

        var scene = Scene(helloView, 800.0, 600.0)
        primaryStage?.title = "JBud"
        primaryStage?.scene = scene
        primaryStage?.show()
    }
}