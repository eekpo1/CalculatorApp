package model

import javafx.application.Application
import view.MyCalculator
import java.lang.StringBuilder
import java.util.*
import kotlin.math.*
import kotlin.test.DefaultAsserter.fail


fun main() {
    Application.launch(MyCalculator::class.java)

    println(Calculator.calculate("5*5+6*1"))
}



/**
 * Run using play.kotlinlang.org if you need a compiler
 *
 */
object Calculator {
    private val operationStack = Stack<Operation>()
    private val valueStack = Stack<Number>()
    private var preparedStatement = ""

    private var twoInputOperations = setOf(Operation.ADD, Operation.SUBTRACT, Operation.MULTIPLY,
        Operation.DIVIDE, Operation.POWER)

    private var oneInputOperation = setOf(Operation.SIN, Operation.COS)

    fun calculate(statement: String) : String {
        // Prepares the statement for parsing and pushes the operations in the operation stack
        prepare(statement)

        // Testing
//        println(valueStack)
//        println(operationStack)
        // Testing over

        /**
         * This function is meant to repeat the popping of the stack until the operation stack is empty.
         */
        while (!operationStack.empty()) {
            val operation = operationStack.pop()

            operate(operation)
        }

        return valueStack.pop().toString()
    }

    private fun operate(operation: Operation) {

        if (!operationStack.empty()) {
            val topOfStack = operationStack.peek()
            if (topOfStack.priority > operation.priority) {
                val temp = valueStack.pop()
                operate(operationStack.pop())
                valueStack.push(temp)
            }
        }
        when {
            // stack operation for a two input operation like add subtract etc
            twoInputOperations.contains(operation) -> {
                when (valueStack.size > 1) {
                    true -> handleTwoInput(operation, valueStack.pop(), valueStack.pop())
                    // continues the loop for a two input operation if the valuestack is a 2 input operation
                    false -> fail("invalid operation order")
                }

            }

            // stack for a one input operation like sin, cos, etc
            oneInputOperation.contains(operation) ->
                handleOneInput(operation, valueStack.pop())
        }
    }

    private fun handleOneInput(operation: Operation, variable: Number) {
        when (operation) {
            Operation.SIN -> {
                valueStack.push(sin(variable.toDouble()))
            }

            Operation.COS -> {
                valueStack.push(cos(variable.toDouble()))
            }

            Operation.SQRT -> {
                valueStack.push(sqrt(variable.toDouble()))
            }

            Operation.E -> {
                valueStack.push(exp(variable.toDouble()))
            }

            Operation.TAN -> {
                valueStack.push(tan(variable.toDouble()))
            }

            Operation.LN -> {
                valueStack.push(ln(variable.toDouble()))
            }

            else -> fail("Invalid one input operation detected. failing")
        }
    }


    private fun handleTwoInput(operation: Operation, val2: Number, val1: Number) {
        when (operation) {
            Operation.ADD -> valueStack.push(val1.toDouble() + val2.toDouble())
            Operation.SUBTRACT -> valueStack.push(val1.toDouble() - val2.toDouble())
            Operation.MULTIPLY -> valueStack.push(val1.toDouble() * val2.toDouble())
            Operation.DIVIDE -> valueStack.push(val1.toDouble() / val2.toDouble())
            Operation.POWER -> valueStack.push((val1.toDouble()).pow(val2 as Int))
            else -> fail("Invalid two input operation detected. failing")
        }

    }


    /**
     * This parses the statement and puts the values in their correct stack. It reads in reverse to handle the cos / sin
     * issue that may arise when using sin and cosine operations
     */
    private fun prepare(statement: String) {
        preparedStatement = statement.replace(" ", "").toLowerCase()
        preparedStatement = preparedStatement
            .replace("sin", Operation.SIN.type.toString())
            .replace("cos", Operation.COS.type.toString())
            .replace("tan", Operation.TAN.type.toString())
            .replace("sqrt", Operation.SQRT.type.toString())
            .replace("ln", Operation.LN.type.toString())

        println(preparedStatement)
        val temp = StringBuilder()
        var idx = 0
        for (i in preparedStatement) {
            idx++
            if (i.isDigit().or(i == '.')) {
                temp.append(i)
                if (idx == preparedStatement.length) {
                    valueStack.push(if (temp.contains('.')) temp.toString().toDouble() else temp.toString().toInt())
                } else continue
            } else {
                if (temp.isNotEmpty()) {
                    valueStack.push(if (temp.contains('.')) temp.toString().toDouble() else temp.toString().toInt())
                }
                temp.delete(0, temp.length)
                val operation: Operation = when (i) {
                    '+' -> Operation.ADD
                    '-' -> Operation.SUBTRACT
                    '*' -> Operation.MULTIPLY
                    '/' -> Operation.DIVIDE
                    '^' -> Operation.POWER
                    '@' -> Operation.COS
                    '#' -> Operation.SIN
                    '_' -> Operation.SQRT
                    'e' -> Operation.E
                    'l' -> Operation.LN
                    't' -> Operation.TAN
                    else -> fail("Detected wrong symbol")

                }
                operationStack.push(operation)
            }
//            println(idx)
        }
    }
}