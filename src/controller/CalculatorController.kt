package controller

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button

import javafx.scene.layout.VBox
import java.awt.TextField
import java.net.URL
import java.util.*


class CalculatorController : Initializable{
    @FXML
    private var vBox: VBox = VBox()

    @FXML
    private lateinit var textField: TextField

    @FXML
    private lateinit var buttonOne: Button

    @FXML
    private lateinit var buttonCos: Button

    @FXML
    private lateinit var buttonSin: Button

    @FXML
    private lateinit var buttonLn: Button

    @FXML
    private lateinit var buttonE: Button

    @FXML
    private lateinit var buttonTan: Button

    @FXML
    private lateinit var buttonClear: Button

    @FXML
    private lateinit var buttonDel: Button

    @FXML
    private lateinit var buttonRadix: Button

    @FXML
    private lateinit var buttonSq: Button

    @FXML
    private lateinit var buttonSqrt: Button

    @FXML
    private lateinit var buttonMinus: Button

    @FXML
    private lateinit var buttonPlus: Button

    @FXML
    private lateinit var buttonThree: Button

    @FXML
    private lateinit var buttonTwo: Button

    @FXML
    private lateinit var buttonMult: Button

    @FXML
    private lateinit var buttonSix: Button

    @FXML
    private lateinit var buttonFive: Button

    @FXML
    private lateinit var buttonFour: Button

    @FXML
    private lateinit var buttonEight: Button

    @FXML
    private lateinit var buttonSeven: Button

    @FXML
    private lateinit var buttonDivide: Button

    @FXML
    private lateinit var buttonNine: Button

    @FXML
    private lateinit var buttonCalculate: Button

    @FXML
    private lateinit var buttonZero: Button

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}