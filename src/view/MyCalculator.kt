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

    /**
     * Starts the javafx console
     */
    override fun start(stage: Stage) {
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