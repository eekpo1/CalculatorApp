package view

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class MyCalculator : Application() {

    // Optional for the jfx
    init {
        println("Welcome to the calculator")
    }

    override fun start(stage: Stage) {
        // Creating Components
//        val parent = VBox()
//        val scene = Scene(parent, 400.0, 400.0)
//        val textField = TextField()
//
//        val grid = GridPane()
//        val buttonArray = createButtons()
//
//
//        parent.minHeight(50.0)
//        textField.isEditable = false
//
//        parent.children.add(textField)
//
//
//        stage.scene = scene
//        val root: Parent = FXMLLoader.load(MyCalculator::class.java.getResource("sample.fxml"))
        val loader: Parent = FXMLLoader.load(MyCalculator::class.java.classLoader.getResource("resources/FixedSample.fxml"))
        val scene = Scene(loader)
        stage.scene = scene
        stage.title = "Calculator"
        stage.isResizable = true
        stage.show()
    }


    override fun stop() {
        super.stop()
        println("Exiting")
    }


}