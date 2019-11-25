package view

import controller.CalculatorController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
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
        val loader = FXMLLoader(MyCalculator::class.java.getResource("C:\\Users\\eddie\\Documents\\Calc\\src\\sample.fxml"))
        val root: Parent = loader.load()
        val scene = Scene(root)
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