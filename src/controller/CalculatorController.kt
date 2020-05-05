
/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */
package controller

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import model.Calculator
import java.net.URL
import java.util.*

class CalculatorController {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private val resources: ResourceBundle? = null
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private val location: URL? = null


    @FXML // fx:id="vBox"
    private lateinit var vBox // Value injected by FXMLLoader
            : VBox
    @FXML // fx:id="textField"
    private lateinit var textField // Value injected by FXMLLoader
            : TextField
    @FXML // fx:id="buttonOne"
    private lateinit var buttonOne // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonCos"
    private lateinit var buttonCos // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonSin"
    private lateinit var buttonSin // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonLn"
    private lateinit var buttonLn // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonE"
    private lateinit var buttonE // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonTan"
    private lateinit var buttonTan // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonClear"
    private lateinit var buttonClear // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonDel"
    private lateinit var buttonDel // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonRadix"
    private lateinit var buttonRadix // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonSq"
    private lateinit var buttonSq // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonSqrt"
    private lateinit var buttonSqrt // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonMinus"
    private lateinit var buttonMinus // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonPlus"
    private lateinit var buttonPlus // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonThree"
    private lateinit var buttonThree // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonTwo"
    private lateinit var buttonTwo // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonMult"
    private lateinit var buttonMult // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonSix"
    private lateinit var buttonSix // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonFive"
    private lateinit var buttonFive // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonFour"
    private lateinit var buttonFour // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonEight"
    private lateinit var buttonEight // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonSeven"
    private lateinit var buttonSeven // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonDivide"
    private lateinit var buttonDivide // Value injected by FXMLLoader
            : Button
    @FXML // fx:id="buttonNine"
    private lateinit var buttonNine // Value injected by FXMLLoader
            : Button

    @FXML // fx:id="buttonCalculate"
    private lateinit var buttonCalculate: Button

    @FXML // fx:id="buttonZero"
    private lateinit var buttonZero: Button

    @FXML
    fun  // This method is called by the FXMLLoader when initialization is complete
            initialize() {

        // Simple Buttons
        buttonOne.setOnAction { textField.text = textField.text.plus("1") }
        buttonTwo.setOnAction { textField.text = textField.text.plus("2") }
        buttonThree.setOnAction { textField.text = textField.text.plus("3") }
        buttonFour.setOnAction { textField.text = textField.text.plus("4") }
        buttonFive.setOnAction { textField.text = textField.text.plus("5") }
        buttonSix.setOnAction { textField.text = textField.text.plus("6") }
        buttonSeven.setOnAction { textField.text = textField.text.plus("7") }
        buttonEight.setOnAction { textField.text = textField.text.plus("8") }
        buttonNine.setOnAction { textField.text = textField.text.plus("9") }
        buttonRadix.setOnAction { textField.text = textField.text.plus(".") }
        buttonZero.setOnAction { textField.text = textField.text.plus("0") }

        // Operators that are simple
        buttonMinus.setOnAction { textField.text = textField.text.plus("-") }
        buttonPlus.setOnAction { textField.text = textField.text.plus("+") }
        buttonDivide.setOnAction { textField.text = textField.text.plus("/") }
        buttonSqrt.setOnAction { textField.text = textField.text.plus("√") }
        buttonSq.setOnAction { textField.text = textField.text.plus("^") }
        buttonMult.setOnAction { textField.text = textField.text.plus("*") }

        // A bit more complex button listeners
        buttonSin.setOnAction {
            textField.text = if (textField.length == 0 || !textField.text.last().isDigit()) textField.text.plus("sin ")
            else textField.text.plus("*sin ")
        }

        buttonCos.setOnAction {
            textField.text = if (textField.length == 0 || !textField.text.last().isDigit()) textField.text.plus("cos ")
            else textField.text.plus("*cos ")
        }

        buttonTan.setOnAction {
            textField.text = if (textField.length == 0 || !textField.text.last().isDigit()) textField.text.plus("tan ")
            else textField.text.plus("*tan ")
        }

        buttonE.setOnAction {
            textField.text = if (textField.length == 0 || !textField.text.last().isDigit()) textField.text.plus("e ")
            else textField.text.plus("*e ")
        }

        buttonLn.setOnAction {
            textField.text = if (textField.length == 0 || !textField.text.last().isDigit())
                textField.text.plus("ln ") else textField.text.plus("*ln ")
        }

        buttonE.setOnAction {
            textField.text = if (textField.length == 0 || !textField.text.last().isDigit()) textField.text.plus("e ")
            else textField.text.plus("*e ")
        }

        buttonDel.setOnAction { if (textField.length > 0) textField.text =
            textField.text.substring(0, textField.length - 1) }

        buttonClear.setOnAction { textField.text = "" }

        buttonCalculate.setOnAction {
            val ans = Calculator.calculate(textField.text)
            if (ans.contains("Inf")) textField.text = "NaN"
            else textField.text = ans
        }

    }
}